package database;

import models.Model;
import models.Station;
import models.Train_Extra;
import models.Trip;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TripHandler implements ModelHandler {
    private final DatabaseConnectionHandler dbHandler;
    private final Connection connection;
    private static final String EXCEPTION_TAG = DatabaseConnectionHandler.getExceptionTag();
    private static final String WARNING_TAG = DatabaseConnectionHandler.getWarningTag();

    public TripHandler(DatabaseConnectionHandler dbHandler) {
        this.dbHandler = dbHandler;
        this.connection = dbHandler.getConnection();
    }

    @Override
    public void insert(Model model) {
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
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            dbHandler.rollbackConnection();
        }
    }

    @Override
    public void update(Model model, String primaryKey) {
        // TODO
    }

    // primaryKey: "seatNum!routeID!passengerID!trainID"
    @Override
    public void delete(String primaryKey) {
        String[] splitKey = primaryKey.split("!");
        int seatNum = Integer.parseInt(splitKey[0]);
        int routeID = Integer.parseInt(splitKey[1]);
        int passengerID = Integer.parseInt(splitKey[2]);
        int trainID = Integer.parseInt(splitKey[3]);

        try {
            String query = "DELETE FROM Trip WHERE (seatNum, routeID, passengerID, trainID) = (?,?,?,?)";
            ca.ubc.cs304.util.PrintablePreparedStatement ps = new ca.ubc.cs304.util.PrintablePreparedStatement(connection.prepareStatement(query), query, false);
            ps.setInt(1, seatNum);
            ps.setInt(2, routeID);
            ps.setInt(3, passengerID);
            ps.setInt(4, trainID);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println(WARNING_TAG + " Trip '(" + seatNum + "," + routeID + "," + passengerID + "," + trainID + ")' does not exist!");
            }

            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            dbHandler.rollbackConnection();
        }
    }

    @Override
    public Model[] getInfo() {
        ArrayList<Trip> result = new ArrayList<Trip>();

        try {
            String query = "SELECT * FROM Trip";
            ca.ubc.cs304.util.PrintablePreparedStatement ps = new ca.ubc.cs304.util.PrintablePreparedStatement(connection.prepareStatement(query), query, false);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Trip trip = new Trip(rs.getInt("seatNum"),rs.getInt("routeID"),rs.getInt("passengerID"),rs.getInt("trainID"));
                result.add(trip);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new Trip[result.size()]);
    }
}
