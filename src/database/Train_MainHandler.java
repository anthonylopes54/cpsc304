package database;

import models.Model;
import models.Station;
import models.Train_Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Train_MainHandler implements ModelHandler {
    private final DatabaseConnectionHandler dbHandler;
//    private final Connection connection;
    private static final String EXCEPTION_TAG = DatabaseConnectionHandler.getExceptionTag();
    private static final String WARNING_TAG = DatabaseConnectionHandler.getWarningTag();

    public Train_MainHandler(DatabaseConnectionHandler dbHandler) {
        this.dbHandler = dbHandler;
//        this.connection = dbHandler.getConnection();
    }

    @Override
    public void insert(Model model, Connection connection) {
        Train_Main train = (Train_Main) model;

        try {
            String query = "INSERT INTO Train_Main VALUES (?,?,?)";
            ca.ubc.cs304.util.PrintablePreparedStatement ps = new ca.ubc.cs304.util.PrintablePreparedStatement(connection.prepareStatement(query), query, false);
            ps.setInt(1, train.getTrainID());
            ps.setString(2, train.getModel());
            ps.setInt(3, train.getManufactureYear());

            ps.executeUpdate();
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            dbHandler.rollbackConnection();
        }
    }

    // primaryKey: trainID
    @Override
    public void update(Model model, Connection connection) {
        // TODO
    }

    @Override
    public void delete(Model model, Connection connection) {
        Train_Main train_main = (Train_Main) model;
        int trainID = train_main.getTrainID();

        try {
            String query = "DELETE FROM Train_Main WHERE trainID = ?";
            ca.ubc.cs304.util.PrintablePreparedStatement ps = new ca.ubc.cs304.util.PrintablePreparedStatement(connection.prepareStatement(query), query, false);
            ps.setInt(1, trainID);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println(WARNING_TAG + " Train_Main '" + trainID + "' does not exist!");
            }

            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            dbHandler.rollbackConnection();
        }
    }

    @Override
    public Model[] getInfo(Connection connection) {
        ArrayList<Train_Main> result = new ArrayList<>();

        try {
            String query = "SELECT * FROM Train_Main";
            ca.ubc.cs304.util.PrintablePreparedStatement ps = new ca.ubc.cs304.util.PrintablePreparedStatement(connection.prepareStatement(query), query, false);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Train_Main train = new Train_Main(
                        rs.getInt("trainID"),
                        rs.getString("model"),
                        rs.getInt("manufactureYear"));
                result.add(train);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new Train_Main[result.size()]);    }
}
