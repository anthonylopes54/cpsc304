package database;

import models.Model;
import models.Station;
import models.StoredAt;
import models.Train_Extra;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Train_ExtraHandler implements ModelHandler {
    private final DatabaseConnectionHandler dbHandler;
    private final Connection connection;
    private static final String EXCEPTION_TAG = DatabaseConnectionHandler.getExceptionTag();
    private static final String WARNING_TAG = DatabaseConnectionHandler.getWarningTag();

    public Train_ExtraHandler(DatabaseConnectionHandler dbHandler) {
        this.dbHandler = dbHandler;
        this.connection = dbHandler.getConnection();
    }

    @Override
    public void insert(Model model) {
        Train_Extra train_extra = (Train_Extra) model;

        try {
            String query = "INSERT INTO Train_Extra VALUES (?,?,?,?)";
            ca.ubc.cs304.util.PrintablePreparedStatement ps = new ca.ubc.cs304.util.PrintablePreparedStatement(connection.prepareStatement(query), query, false);
            ps.setString(1, train_extra.getModel());
            ps.setInt(2, train_extra.getManufactureYear());
            ps.setInt(3, train_extra.getNumSeats());
            ps.setInt(4, train_extra.getNumCars());

            ps.executeUpdate();
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            dbHandler.rollbackConnection();
        }
    }

    @Override
    public void update(Model model, String primaryKey) {
        // TODO
    }

    @Override
    public void delete(String primaryKey) {
        // TODO: get key (model, manufactureYear) from primaryKey
        String model = "";
        int manufactureYear = -1;

        try {
            String query = "DELETE FROM Train_Extra WHERE (model, manufactureYear) = (?,?)";
            ca.ubc.cs304.util.PrintablePreparedStatement ps = new ca.ubc.cs304.util.PrintablePreparedStatement(connection.prepareStatement(query), query, false);
            ps.setString(1, model);
            ps.setInt(2, manufactureYear);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println(WARNING_TAG + " Train_Extra '(" + model + "," + manufactureYear + ")' does not exist!");
            }

            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            dbHandler.rollbackConnection();
        }
    }

    @Override
    public Model[] getInfo() {
        ArrayList<Train_Extra> result = new ArrayList<Train_Extra>();

        try {
            String query = "SELECT * FROM Train_Extra";
            ca.ubc.cs304.util.PrintablePreparedStatement ps = new ca.ubc.cs304.util.PrintablePreparedStatement(connection.prepareStatement(query), query, false);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Train_Extra train_extra = new Train_Extra(rs.getString("model"),rs.getInt("manufactureYear"),rs.getInt("numSeats"),rs.getInt("numCars"));
                result.add(train_extra);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new Train_Extra[result.size()]);
    }
}
