package database;

import models.Route;
import models.Seat_CarMapping;
import models.Seat_Main;
import util.Constants;
import util.ModelType;
import models.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionHandler {
    private Connection connection = null;

    public DatabaseConnectionHandler() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
            }
        }
    }

    public boolean login(String username, String password) {
        try {
            if (connection != null) {
                connection.close();
            }

            connection = DriverManager.getConnection(Constants.ORACLE_URL, username, password);
            connection.setAutoCommit(false);

            System.out.println("\nConnected to Oracle!");
            return true;
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
            return false;
        }
    }

    public void delete(Model model, int id) {
        switch (model.type) {
            case DRIVES -> {
                DrivesHandler drivesHandler = new DrivesHandler();
                drivesHandler.delete(model, connection);
            }
            case TRIP -> {

            }
            case ROUTE -> {
                RouteHandler routeHandler = new RouteHandler();
                routeHandler.delete(model, connection);
            }
            case MANAGES -> {
                ManagesHandler managesHandler = new ManagesHandler();
                managesHandler.delete(model, connection);
            }
            case STATION -> {

            }
            case EMPLOYEE -> {
                EmployeeHandler employeeHandler = new EmployeeHandler();
                employeeHandler.delete(model, connection);
            }
            case MAINTAINS -> {
                MaintainsHandler maintainsHandler = new MaintainsHandler();
                maintainsHandler.delete(model, connection);
            }
            case PASSENGER -> {
                PassengerHandler passengerHandler = new PassengerHandler();
                passengerHandler.delete(model, connection);
            }
            case SEAT_MAIN -> {
                Seat_MainHandler seat_mainHandler = new Seat_MainHandler();
                seat_mainHandler.delete(model, connection);
            }
            case SEAT_CAR_MAPPING -> {
                Seat_CarMappingHandler seat_CarMappingHandler = new Seat_CarMappingHandler();
                seat_CarMappingHandler.delete(model, connection);
            }
            case STORED_AT -> {

            }
            case TRAIN_EXTRA -> {

            }
            case TRAIN_MAIN_INFO -> {

            }
            case GOES_THROUGH -> {
                GoesThroughHandler goesThroughHandler = new GoesThroughHandler();
                goesThroughHandler.delete(model, connection);
            }
            case CARGO_BELONGS_TO -> {
                Cargo_BelongsToHandler cargo_belongsToHandler = new Cargo_BelongsToHandler();
                cargo_belongsToHandler.delete(model, connection);
            }
            default -> {
                // no-op
            }
        }
    }

    public void insert(Model model) {
        switch (model.type) {
            case DRIVES -> {
                DrivesHandler dh = new DrivesHandler();
                dh.Insert(model, connection);
            }
            case TRIP -> {

            }
            case ROUTE -> {

            }
            case MANAGES -> {
                ManagesHandler managesHandler = new ManagesHandler();
                managesHandler.Insert(model, connection);
            }
            case STATION -> {

            }
            case EMPLOYEE -> {
                EmployeeHandler employeeHandler = new EmployeeHandler();
                employeeHandler.Insert(model, connection);
            }
            case MAINTAINS -> {

            }
            case PASSENGER -> {

            }
            case SEAT_MAIN -> {

            }
            case SEAT_CAR_MAPPING -> {

            }
            case STORED_AT -> {

            }
            case TRAIN_EXTRA -> {

            }
            case TRAIN_MAIN_INFO -> {

            }
            case GOES_THROUGH -> {
                GoesThroughHandler goesThroughHandler = new GoesThroughHandler();
                goesThroughHandler.Insert(model, connection);
            }
            case CARGO_BELONGS_TO -> {
                Cargo_BelongsToHandler cbtHandler = new Cargo_BelongsToHandler();
                cbtHandler.Insert(model, connection);
            }
            default -> {
                // no-op
            }
        }
    }

    public Model[] getInfo(ModelType type) {
        switch (type) {
            case DRIVES -> {
                DrivesHandler drivesHandler = new DrivesHandler();
                return drivesHandler.getInfo(connection);
            }
            case TRIP -> {

            }
            case ROUTE -> {

            }
            case MANAGES -> {
                ManagesHandler managesHandler = new ManagesHandler();
                return managesHandler.getInfo(connection);
            }
            case STATION -> {

            }
            case EMPLOYEE -> {
                EmployeeHandler employeeHandler = new EmployeeHandler();
                return employeeHandler.getInfo(connection);
            }
            case MAINTAINS -> {

            }
            case PASSENGER -> {

            }
            case SEAT_MAIN -> {

            }
            case SEAT_CAR_MAPPING -> {

            }
            case STORED_AT -> {

            }
            case TRAIN_EXTRA -> {

            }
            case TRAIN_MAIN_INFO -> {

            }
            case GOES_THROUGH -> {
                GoesThroughHandler goesThroughHandler = new GoesThroughHandler();
                return goesThroughHandler.getInfo(connection);
            }
            case CARGO_BELONGS_TO -> {
                Cargo_BelongsToHandler cargo_belongsToHandler = new Cargo_BelongsToHandler();
                return cargo_belongsToHandler.getInfo(connection);
            }
            default -> {
                // no-op
            }
        }
        return null;
    }

    public void update(Model model, int id) {
        switch (model.type) {
            case DRIVES -> {
                DrivesHandler drivesHandler = new DrivesHandler();
                drivesHandler.update(model, connection);
            }
            case TRIP -> {

            }
            case ROUTE -> {

            }
            case MANAGES -> {
                ManagesHandler managesHandler = new ManagesHandler();
                managesHandler.update(model, connection);
            }
            case STATION -> {

            }
            case EMPLOYEE -> {
                EmployeeHandler employeeHandler = new EmployeeHandler();
                employeeHandler.update(model, connection);
            }
            case MAINTAINS -> {

            }
            case PASSENGER -> {

            }
            case SEAT_MAIN -> {

            }
            case SEAT_CAR_MAPPING -> {

            }
            case STORED_AT -> {

            }
            case TRAIN_EXTRA -> {

            }
            case TRAIN_MAIN_INFO -> {

            }
            case GOES_THROUGH -> {
                GoesThroughHandler goesThroughHandler = new GoesThroughHandler();
                goesThroughHandler.update(model, connection);
            }
            case CARGO_BELONGS_TO -> {
                Cargo_BelongsToHandler cargo_belongsToHandler = new Cargo_BelongsToHandler();
                cargo_belongsToHandler.update(model, connection);
            }
            default -> {
                // no-op
            }
        }
    }
}
