package controller;

import database.DatabaseConnectionHandler;

public class Trip {

    DatabaseConnectionHandler dbHandler = new DatabaseConnectionHandler();

    public static void main(String[] args) {

    }

    public String joinQuery(String passengerId) {
        return dbHandler.getCargo(Integer.parseInt(passengerId));
    }
}
