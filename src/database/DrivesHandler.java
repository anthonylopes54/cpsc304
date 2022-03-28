package database;

import models.Drives;
import models.Model;
import util.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DrivesHandler implements ModelHandler {
    @Override
    public void insert(Model modal, Connection connection) {
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
        System.out.println(Constants.WARNING_TAG + " Drives table should not be updated; only inserted and deleted");
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
        ArrayList<Drives> res = new ArrayList<>();
        String query = "SELECT * FROM Drives";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                Drives drives = new Drives(
                        Integer.parseInt(resultSet.getString("empID")),
                        Integer.parseInt(resultSet.getString("trainID"))
                );
                res.add(drives);
            }
            resultSet.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
        return res.toArray(new Drives[0]);
    }
}
