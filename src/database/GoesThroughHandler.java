package database;

import models.GoesThrough;
import models.Model;
import util.Constants;

import java.sql.*;
import java.util.ArrayList;

public class GoesThroughHandler implements ModelHandler {
    @Override
    public void Insert(Model model, Connection connection) {
        GoesThrough goesThrough = (GoesThrough) model;
        String query = "INSERT INTO GoesThrough VALUES (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, goesThrough.getStationName());
            ps.setTimestamp(2, (Timestamp) goesThrough.getTimeOfStop()); // TODO: Is this a timestamp?
            ps.setInt(3, goesThrough.getRouteID());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    @Override
    public void update(Model model, Connection connection) {
        GoesThrough goesThrough = (GoesThrough) model;
        String query = "UPDATE GoesThrough SET timeOfStop = ? WHERE name = ? AND routeID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setTimestamp(1, (Timestamp) goesThrough.getTimeOfStop()); // TODO
            ps.setString(2, goesThrough.getStationName());
            ps.setInt(3, goesThrough.getRouteID());
            int numOfRows = ps.executeUpdate();
            if (numOfRows == 0) {
                System.out.println(
                        Constants.WARNING_TAG +
                                " GoesThrough {name: " +
                                goesThrough.getStationName() +
                                "; routeID: " +
                                goesThrough.getRouteID() +
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
        GoesThrough goesThrough = (GoesThrough) model;
        String query = "DELETE FROM GoesThrough WHERE name = ? AND routeID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, goesThrough.getStationName());
            ps.setInt(2, goesThrough.getRouteID());
            int numOfRows = ps.executeUpdate();
            if (numOfRows == 0) {
                System.out.println(
                        Constants.WARNING_TAG +
                                " GoesThrough {name: " +
                                goesThrough.getStationName() +
                                "; routeID: " +
                                goesThrough.getRouteID() +
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
        ArrayList<GoesThrough> res = new ArrayList<>();
        String query = "SELECT * FROM GoesThrough";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                GoesThrough goesThrough = new GoesThrough(
                        resultSet.getString("name"),
                        resultSet.getDate("timeOfStop"),
                        resultSet.getInt("routeID")
                );
                res.add(goesThrough);
            }
            resultSet.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
        return res.toArray(new GoesThrough[0]);
    }
}
