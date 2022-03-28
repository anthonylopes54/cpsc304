package database;

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
                TripHandler tripHandler = new TripHandler(this);
                tripHandler.delete(model, connection);
            }
            case ROUTE -> {

            }
            case MANAGES -> {
                ManagesHandler managesHandler = new ManagesHandler();
                managesHandler.delete(model, connection);
            }
            case STATION -> {
                StationHandler stationHandler = new StationHandler(this);
                stationHandler.delete(model, connection);
            }
            case EMPLOYEE -> {
                EmployeeHandler employeeHandler = new EmployeeHandler();
                employeeHandler.delete(model, connection);
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
                StoredAtHandler storedAtHandler = new StoredAtHandler(this);
                storedAtHandler.delete(model, connection);
            }
            case TRAIN_EXTRA -> {
                Train_ExtraHandler train_extraHandler = new Train_ExtraHandler(this);
                train_extraHandler.delete(model, connection);
            }
            case TRAIN_MAIN -> {
                Train_MainHandler train_mainHandler = new Train_MainHandler(this);
                train_mainHandler.delete(model, connection);
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
                dh.insert(model, connection);
            }
            case TRIP -> {
                TripHandler tripHandler = new TripHandler(this);
                tripHandler.insert(model, connection);
            }
            case ROUTE -> {

            }
            case MANAGES -> {
                ManagesHandler managesHandler = new ManagesHandler();
                managesHandler.insert(model, connection);
            }
            case STATION -> {
                StationHandler stationHandler = new StationHandler(this);
                stationHandler.insert(model, connection);
            }
            case EMPLOYEE -> {
                EmployeeHandler employeeHandler = new EmployeeHandler();
                employeeHandler.insert(model, connection);
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
                StoredAtHandler storedAtHandler = new StoredAtHandler(this);
                storedAtHandler.insert(model, connection);
            }
            case TRAIN_EXTRA -> {
                Train_ExtraHandler train_extraHandler = new Train_ExtraHandler(this);
                train_extraHandler.insert(model, connection);
            }
            case TRAIN_MAIN -> {
                Train_MainHandler train_mainHandler = new Train_MainHandler(this);
                train_mainHandler.insert(model, connection);
            }
            case GOES_THROUGH -> {
                GoesThroughHandler goesThroughHandler = new GoesThroughHandler();
                goesThroughHandler.insert(model, connection);
            }
            case CARGO_BELONGS_TO -> {
                Cargo_BelongsToHandler cbtHandler = new Cargo_BelongsToHandler();
                cbtHandler.insert(model, connection);
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
                TripHandler tripHandler = new TripHandler(this);
                tripHandler.getInfo(connection);
            }
            case ROUTE -> {

            }
            case MANAGES -> {
                ManagesHandler managesHandler = new ManagesHandler();
                return managesHandler.getInfo(connection);
            }
            case STATION -> {
                StationHandler stationHandler = new StationHandler(this);
                stationHandler.getInfo(connection);
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
                StoredAtHandler storedAtHandler = new StoredAtHandler(this);
                storedAtHandler.getInfo(connection);
            }
            case TRAIN_EXTRA -> {
                Train_ExtraHandler train_extraHandler = new Train_ExtraHandler(this);
                train_extraHandler.getInfo(connection);
            }
            case TRAIN_MAIN -> {
                Train_MainHandler train_mainHandler = new Train_MainHandler(this);
                train_mainHandler.getInfo(connection);
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
                TripHandler tripHandler = new TripHandler(this);
                tripHandler.update(model, connection);
            }
            case ROUTE -> {

            }
            case MANAGES -> {
                ManagesHandler managesHandler = new ManagesHandler();
                managesHandler.update(model, connection);
            }
            case STATION -> {
                StationHandler stationHandler = new StationHandler(this);
                stationHandler.update(model, connection);
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
                StoredAtHandler storedAtHandler = new StoredAtHandler(this);
                storedAtHandler.update(model, connection);
            }
            case TRAIN_EXTRA -> {
                Train_ExtraHandler train_extraHandler = new Train_ExtraHandler(this);
                train_extraHandler.update(model, connection);
            }
            case TRAIN_MAIN -> {
                Train_MainHandler train_mainHandler = new Train_MainHandler(this);
                train_mainHandler.update(model, connection);
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

    public void rollbackConnection() {
        try  {
            connection.rollback();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
    }

}
