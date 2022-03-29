package database;

import models.Drives;
import models.Maintains;
import models.Model;
import util.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;


public class MaintainsHandler implements ModelHandler{

    @Override
    public void insert(Model model, Connection connection) {
        Maintains maintains = (Maintains) model;
        String query = "INSERT INTO Maintains VALUES (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, maintains.getEmpID());
            ps.setInt(2, maintains.getTrainID());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
    }


    @Override
    public void update(Model model, Connection connection) {
        System.out.println(Constants.WARNING_TAG + " Maintains table should not be updated; only inserted and deleted");
    }

    @Override
    public void delete(Model model, Connection connection) {
        Maintains maintains = (Maintains) model;
        String query = "DELETE FROM Maintains WHERE empID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, maintains.getEmpID());

            int numOfRows = ps.executeUpdate();
            if (numOfRows == 0) {
                System.out.println(
                        Constants.WARNING_TAG +
                                " Maintains {empID: " +
                                maintains.getEmpID() +
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
        ArrayList<Maintains> res = new ArrayList<>();
        String query = "SELECT * FROM Maintains";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                Maintains maintains = new Maintains(
                        Integer.parseInt(resultSet.getString("empID")),
                        Integer.parseInt(resultSet.getString("trainID"))
                );
                res.add(maintains);
            }
            resultSet.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
        return res.toArray(new Maintains[0]);


    }
}
