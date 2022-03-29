package database;

import models.Drives;
import models.Model;
import models.Passenger;
import models.Route;
import util.Constants;

import java.sql.*;
import java.util.ArrayList;

public class RouteHandler implements ModelHandler {

    @Override
    public void insert(Model model, Connection connection) {
        Route route = (Route) model;
        String query = "INSERT INTO Route VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,route.getRouteID());
            ps.setString(2, route.getDepartureStation());
            ps.setString(3, route.getDestinationStation());
            ps.setInt(4, route.getTripDistance());
            ps.setInt(5, route.getEstimatedDuration());
            ps.setTimestamp(6, route.getDepartureTime());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    @Override
    public void update(Model model, Connection connection) {
        Route route = (Route) model;
        String query = "UPDATE Route SET departureStation = ?, destinationStation = ?, tripDistance = ?, estimatedDuration = ?, departureTime = ?, WHERE routeID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, route.getDepartureStation());
            ps.setString(2, route.getDestinationStation());
            ps.setInt(3, route.getTripDistance());
            ps.setInt(4, route.getEstimatedDuration());
            ps.setTimestamp(5, route.getDepartureTime());
            ps.setInt(6,route.getRouteID());


            int numOfRows = ps.executeUpdate();
            if (numOfRows == 0) {
                System.out.println(
                        Constants.WARNING_TAG +
                                " Route {routeID: " +
                                route.getRouteID() +
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
        Route route = (Route) model;
        String query = "DELETE FROM Route WHERE routeID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, route.getRouteID());

            int numOfRows = ps.executeUpdate();
            if (numOfRows == 0) {
                System.out.println(
                        Constants.WARNING_TAG +
                                " Route {routeID: " +
                                route.getRouteID() +
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
        ArrayList<Route> res = new ArrayList<>();
        String query = "SELECT * FROM Route";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                Route route = new Route(
                        (resultSet.getInt("routeID")),
                        resultSet.getString("departureStation"),
                        resultSet.getString("destinationStation"),
                        (resultSet.getInt("tripDistance")),
                        (resultSet.getInt("estimatedDuration")),
                        resultSet.getTimestamp("departureTime")
                );

                res.add(route);
            }
            resultSet.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
        return res.toArray(new Route[0]);

    }
}
