package database;

import models.Drives;
import models.Maintains;
import models.Model;
import models.Passenger;
import util.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Connection;

public class PassengerHandler implements ModelHandler {
    @Override
    public void Insert(Model model, Connection connection) {
        Passenger passenger = (Passenger) model;
        String query = "INSERT INTO Passenger VALUES (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, passenger.getPassengerID());
            ps.setString(2, passenger.getName());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }

    }

    @Override
    public void update(Model model, Connection connection) {
        Passenger passenger = (Passenger) model;
        String query = "UPDATE Passenger SET name = ?, WHERE passengerID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, passenger.getName());
            ps.setInt(2, passenger.getPassengerID());

            int numOfRows = ps.executeUpdate();
            if (numOfRows == 0) {
                System.out.println(
                        Constants.WARNING_TAG +
                                " Passenger {passengerID: " +
                                passenger.getPassengerID() +
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
        Passenger passenger = (Passenger) model;
        String query = "DELETE FROM Passenger WHERE passengerID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, passenger.getPassengerID());


            int numOfRows = ps.executeUpdate();
            if (numOfRows == 0) {
                System.out.println(
                        Constants.WARNING_TAG +
                                " Passenger {empID: " +
                                passenger.getPassengerID() +
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
        ArrayList<Passenger> res = new ArrayList<>();
        String query = "SELECT * FROM Passenger";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                Passenger passenger = new Passenger(
                        resultSet.getInt("passengerID"),
                        resultSet.getString("name")
                );
                res.add(passenger);
            }
            resultSet.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
        return res.toArray(new Passenger[0]);


    }
}
