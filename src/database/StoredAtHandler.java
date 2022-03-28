package database;

import models.Model;
import models.StoredAt;
import util.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoredAtHandler implements ModelHandler {
    private final DatabaseConnectionHandler dbHandler;

    public StoredAtHandler(DatabaseConnectionHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    @Override
    public void insert(Model model, Connection connection) {
        StoredAt storedAt = (StoredAt) model;

        try {
            String query = "INSERT INTO StoredAt VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, storedAt.getTrainID());
            ps.setString(2, storedAt.getStationName());

            ps.executeUpdate();
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
            dbHandler.rollbackConnection();
        }
    }

    // primaryKey: trainID
    @Override
    public void update(Model model, Connection connection) {
        StoredAt storedAt = (StoredAt) model;
        int trainID = storedAt.getTrainID();
        String stationName = storedAt.getStationName();

        try {
            String query = "UPDATE StoredAt SET stationName = ? WHERE trainID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(2, trainID);
            ps.setString(1, stationName);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println(Constants.WARNING_TAG + " StoredAt {trainID: " + trainID + "} does not exist!");
            }

            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
            dbHandler.rollbackConnection();
        }
    }

    // primaryKey: trainID
    @Override
    public void delete(Model model, Connection connection) {
        StoredAt storedAt = (StoredAt) model;
        int trainID = storedAt.getTrainID();

        try {
            String query = "DELETE FROM StoredAt WHERE trainID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, trainID);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println(Constants.WARNING_TAG + " StoredAt {trainID: " + trainID + "} does not exist!");
            }

            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
            dbHandler.rollbackConnection();
        }
    }

    @Override
    public Model[] getInfo(Connection connection) {
        ArrayList<StoredAt> result = new ArrayList<>();

        try {
            String query = "SELECT * FROM StoredAt";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                StoredAt storedAt = new StoredAt(
                        rs.getInt("trainID"),
                        rs.getString("stationName"));
                result.add(storedAt);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new StoredAt[result.size()]);
    }
}
