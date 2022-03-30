package controller;

import database.DatabaseConnectionHandler;
import java.util.Date;

public class Trip {
    private static DatabaseConnectionHandler dbHandler;
    private int uniqueID = 1000;

    public Trip() {
        dbHandler = new DatabaseConnectionHandler();
        dbHandler.login("ORA_ALOPES02", "a24280836");
    }

    public String projectionQuery() {
        return dbHandler.getEmployeeProjection();
    }

    public int aggregationQuery(int trainID, int routeID) {
        return dbHandler.getNumPassengers(trainID, routeID);
    }

    public String nestedAggregationQuery() {
        return dbHandler.getNumEmployeesByTrain();
    }

    public String joinQuery(String passengerId) {
        return dbHandler.getCargo(Integer.parseInt(passengerId));
    }

    public String divisionQuery() {
        return dbHandler.getRoutesThatGoThroughAllStations();
    }

    public void insertQuery(String name) {
        //!TODO get Unique ID is just an int that increases everytime you call it
        //this solution should be fine, the UID java class created alphanumerics and couldn't get rid of characters

        dbHandler.addPassenger(this.getUniqueID(), name);

    }

    public void deleteQuery(int passengerId) {
        dbHandler.deletePassenger(passengerId);
    }

    public void updateQuery(int empID, String name, Date date, String email, int salary,
                            String specialization, int freightCar, Date licenseExpiryDate,
                            int licenseNumber, Date certificationIssueDate){
        dbHandler.updateEmployee(empID, name, date, email, salary,
                specialization, freightCar, licenseExpiryDate,
                licenseNumber, certificationIssueDate);
    }

    public String selectionQuery(String model) {
        return dbHandler.getTrainsByModel(model);
    }

    public int getUniqueID(){
        return uniqueID++;
    }
}