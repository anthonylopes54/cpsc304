package database;

import models.Drives;
import models.Model;
import util.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DrivesHandler implements ModelHandler {
    @Override
    public void Insert(Model modal, Connection connection) {
        Drives drives = (Drives) modal;
        String query = "INSERT INTO Drives VALUES (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, drives.getEmpID());
            ps.setInt(2, drives.getTrainID());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    @Override
    public void update(Model modal, Connection connection) {

    }

    @Override
    public void delete(Model model, Connection connection) {
        Drives drives = (Drives) model;
        String query = "DELETE FROM Drives WHERE empID = ? AND trainID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, drives.getEmpID());
            ps.setInt(2, drives.getTrainID());
            int numOfRows = ps.executeUpdate();
            if (numOfRows == 0) {
                System.out.println(
                        Constants.WARNING_TAG +
                        " Drives {empID: " +
                        drives.getEmpID() +
                        "; trainID: " +
                        drives.getTrainID() +
                        "} does not exist!"
                );
            }
            connection.commit();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }

    }

    @Override
    public Model[] getInfo(Connection connection) {
        return new Model[0];
    }
}
