package database;

import models.Drives;
import models.Maintains;
import models.Model;
import models.Seat_CarMapping;
import util.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Seat_CarMappingHandler implements ModelHandler{

    @Override
    public void Insert(Model model, Connection connection) {
        Seat_CarMapping seat_carMapping = (Seat_CarMapping) model;
        String query = "INSERT INTO Seat_CarMapping VALUES (?,?)";
        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1,seat_carMapping.getSeatNum());
            ps.setInt(2, seat_carMapping.getCarNum());

            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    @Override
    public void update(Model model, Connection connection) {
        Seat_CarMapping seat_carMapping = (Seat_CarMapping) model;
        String query = "UPDATE Seat_CarMapping SET carNum = ?, WHERE seatNum = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, seat_carMapping.getCarNum());
            ps.setInt(2,seat_carMapping.getSeatNum());

            int numOfRows = ps.executeUpdate();
            if (numOfRows == 0) {
                System.out.println(
                        Constants.WARNING_TAG +
                                " Seat_CarMapping {seatNum: " +
                                seat_carMapping.getSeatNum() +
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
        Seat_CarMapping seat_carMapping = (Seat_CarMapping) model;
        String query = "DELETE FROM Seat_CarMapping WHERE seatNum = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, seat_carMapping.getSeatNum());

            int numOfRows = ps.executeUpdate();
            if (numOfRows == 0) {
                System.out.println(
                        Constants.WARNING_TAG +
                                " Seat_CarMapping {seatNum: " +
                                seat_carMapping.getSeatNum() +
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
        ArrayList<Seat_CarMapping> res = new ArrayList<>();
        String query = "SELECT * FROM Seat_CarMapping";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                Seat_CarMapping seat_CarMapping = new Seat_CarMapping(
                        (resultSet.getInt("seatNum")),
                        (resultSet.getInt("carNum"))
                );
                res.add(seat_CarMapping);
            }
            resultSet.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
        return res.toArray(new Seat_CarMapping[0]);

    }
}
