package database;

import models.Model;
import models.Station;
import models.StoredAt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoredAtHandler implements ModelHandler {
    private final DatabaseConnectionHandler dbHandler;
    private final Connection connection;
    private static final String EXCEPTION_TAG = DatabaseConnectionHandler.getExceptionTag();
    private static final String WARNING_TAG = DatabaseConnectionHandler.getWarningTag();

    public StoredAtHandler(DatabaseConnectionHandler dbHandler) {
        this.dbHandler = dbHandler;
        this.connection = dbHandler.getConnection();
    }

    @Override
    public void insert(Model model) {
        StoredAt storedAt = (StoredAt) model;

        try {
            String query = "INSERT INTO StoredAt VALUES (?,?)";
            ca.ubc.cs304.util.PrintablePreparedStatement ps = new ca.ubc.cs304.util.PrintablePreparedStatement(connection.prepareStatement(query), query, false);
            ps.setInt(1, storedAt.getTrainID());
            ps.setString(2, storedAt.getStationName());

            ps.executeUpdate();
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            dbHandler.rollbackConnection();
        }
    }

    // primaryKey: "trainID"
    @Override
    public void update(Model model, String primaryKey) {
        // TODO
    }

    @Override
    public void delete(String primaryKey) {
        int trainID = Integer.parseInt(primaryKey);

        try {
            String query = "DELETE FROM StoredAt WHERE trainID = ?";
            ca.ubc.cs304.util.PrintablePreparedStatement ps = new ca.ubc.cs304.util.PrintablePreparedStatement(connection.prepareStatement(query), query, false);
            ps.setInt(1, trainID);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println(WARNING_TAG + " StoredAt '" + trainID + "' does not exist!");
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
        ArrayList<StoredAt> result = new ArrayList<StoredAt>();

        try {
            String query = "SELECT * FROM StoredAt";
            ca.ubc.cs304.util.PrintablePreparedStatement ps = new ca.ubc.cs304.util.PrintablePreparedStatement(connection.prepareStatement(query), query, false);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                StoredAt storedAt = new StoredAt(rs.getInt("trainID"),rs.getString("stationName"));
                result.add(storedAt);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new StoredAt[result.size()]);
    }
}
