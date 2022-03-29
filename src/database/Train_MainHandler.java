package database;

import models.*;
import util.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Train_MainHandler implements ModelHandler {
    private final DatabaseConnectionHandler dbHandler;

    public Train_MainHandler(DatabaseConnectionHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    @Override
    public void insert(Model model, Connection connection) {
        Train_Main train = (Train_Main) model;

        try {
            String query = "INSERT INTO Train_Main VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, train.getTrainID());
            ps.setString(2, train.getModel());
            ps.setInt(3, train.getManufactureYear());

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
        Train_Main train_main = (Train_Main) model;
        int trainID = train_main.getTrainID();
        String trainModel = train_main.getModel();
        int manufactureYear = train_main.getManufactureYear();

        try {
            String query = "UPDATE Train_Main SET model = ?, manufactureYear= ? WHERE trainID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(3, trainID);
            ps.setString(1, trainModel);
            ps.setInt(2, manufactureYear);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println(Constants.WARNING_TAG + " Train_Main {trainID: " + trainID + "} does not exist!");
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
        Train_Main train_main = (Train_Main) model;
        int trainID = train_main.getTrainID();

        try {
            String query = "DELETE FROM Train_Main WHERE trainID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, trainID);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println(Constants.WARNING_TAG + " Train_Main {trainID: " + trainID + "} does not exist!");
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
        ArrayList<Train_Main> result = new ArrayList<>();

        try {
            String query = "SELECT * FROM Train_Main";
            PreparedStatement ps = connection.prepareStatement(query);
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
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new Train_Main[result.size()]);
    }
}
