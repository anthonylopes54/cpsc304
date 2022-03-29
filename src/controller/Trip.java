package controller;

import database.DatabaseConnectionHandler;

import java.sql.ResultSet;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Trip {
    private DatabaseConnectionHandler dbHandler = null;
    private int uniqueID = 2000;

    public Trip() {
        dbHandler = new DatabaseConnectionHandler();
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

    public static void main(String[] args) {

    }
}