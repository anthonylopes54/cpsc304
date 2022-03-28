package database;
import models.Manages;
import models.Model;
import util.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManagesHandler implements ModelHandler {

    @Override
    public void insert(Model model, Connection connection) {
        Manages manages = (Manages) model;
        String query = "INSERT INTO Manages VALUES (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, manages.getEmpID());
            ps.setInt(2, manages.getTrainID());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    @Override
    public void update(Model model, Connection connection) {
        Manages manages = (Manages) model;
        String query = "UPDATE Manages SET trainID = ? WHERE empID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, manages.getTrainID());
            ps.setInt(2, manages.getEmpID());
            int numOfRows = ps.executeUpdate();
            if (numOfRows == 0) {
                System.out.println(
                        Constants.WARNING_TAG +
                                " Manages {empID: " +
                                manages.getEmpID() +
                                "} does not exist!"
                );
            }
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    @Override
    public void delete(Model model, Connection connection) {
        Manages manages = (Manages) model;
        String query = "DELETE FROM Manages WHERE empID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, manages.getEmpID());
            int numOfRows = ps.executeUpdate();
            if (numOfRows == 0) {
                System.out.println(
                        Constants.WARNING_TAG +
                                " Manages {empID: " +
                                manages.getEmpID() +
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
        ArrayList<Manages> res = new ArrayList<>();
        String query = "SELECT * FROM Manages";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                Manages manages = new Manages(
                        Integer.parseInt(resultSet.getString("empID")),
                        Integer.parseInt(resultSet.getString("trainID"))
                );
                res.add(manages);
            }
            resultSet.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
        return res.toArray(new Manages[0]);
    }
}
