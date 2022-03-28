package database;

import models.*;
import util.Constants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TripHandler implements ModelHandler {
    private final DatabaseConnectionHandler dbHandler;

    public TripHandler(DatabaseConnectionHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    @Override
    public void insert(Model model, Connection connection) {
        Trip trip = (Trip) model;

        try {
            String query = "INSERT INTO Trip VALUES (?,?,?,?)";
            ca.ubc.cs304.util.PrintablePreparedStatement ps = new ca.ubc.cs304.util.PrintablePreparedStatement(connection.prepareStatement(query), query, false);
            ps.setInt(1, trip.getSeatNum());
            ps.setInt(2, trip.getRouteID());
            ps.setInt(3, trip.getPassengerID());
            ps.setInt(4, trip.getTrainID());

            ps.executeUpdate();
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
            dbHandler.rollbackConnection();
        }
    }

    // primaryKey: (seatNum, routeID, passengerID, trainID)
    @Override
    public void update(Model model, Connection connection) {
        // every field is part of the key, therefore we can't do any updates
        System.out.println(Constants.WARNING_TAG + "cannot update tuples in Trip table, every field is part of the primary key!");
    }

    // primaryKey: (seatNum, routeID, passengerID, trainID)
    @Override
    public void delete(Model model, Connection connection) {
        Trip trip = (Trip) model;
        int seatNum = trip.getSeatNum();
        int routeID = trip.getRouteID();
        int passengerID = trip.getPassengerID();
        int trainID = trip.getTrainID();

        try {
            String query = "DELETE FROM Trip WHERE (seatNum, routeID, passengerID, trainID) = (?,?,?,?)";
            ca.ubc.cs304.util.PrintablePreparedStatement ps = new ca.ubc.cs304.util.PrintablePreparedStatement(connection.prepareStatement(query), query, false);
            ps.setInt(1, seatNum);
            ps.setInt(2, routeID);
            ps.setInt(3, passengerID);
            ps.setInt(4, trainID);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println(Constants.WARNING_TAG + " Trip '(" + seatNum + "," + routeID + "," + passengerID + "," + trainID + ")' does not exist!");
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
        ArrayList<Trip> result = new ArrayList<>();

        try {
            String query = "SELECT * FROM Trip";
            ca.ubc.cs304.util.PrintablePreparedStatement ps = new ca.ubc.cs304.util.PrintablePreparedStatement(connection.prepareStatement(query), query, false);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Trip trip = new Trip(
                        rs.getInt("seatNum"),
                        rs.getInt("routeID"),
                        rs.getInt("passengerID"),
                        rs.getInt("trainID"));
                result.add(trip);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new Trip[result.size()]);
    }
}
