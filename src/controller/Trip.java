package controller;

import database.DatabaseConnectionHandler;

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

    DatabaseConnectionHandler dbHandler = new DatabaseConnectionHandler();

    public static void main(String[] args) {

    }

    public String joinQuery(String passengerId) {
        return dbHandler.getCargo(Integer.parseInt(passengerId));
    }

    public String divisionQuery() {
        return dbHandler.getRoutesThatGoThroughAllStations();
    }
}
