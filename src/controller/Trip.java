package controller;

import database.DatabaseConnectionHandler;
import database.TripHandler;

public class Trip {
    private DatabaseConnectionHandler dbHandler = null;

    public Trip() {
        dbHandler = new DatabaseConnectionHandler();
    }

    public int aggregationQuery(int trainID, int routeID) {
        return dbHandler.getNumPassengers(trainID, routeID);
    }

    public String nestedAggregationQuery() {
        return dbHandler.getNumEmployeesByTrain();
    }

    public static void main(String[] args) {

    }
}
