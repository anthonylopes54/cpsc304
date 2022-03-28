package database;

import constants.ModelType;
import models.Model;
import models.Station;
import models.Trip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionHandler {

    // Use this version of the ORACLE_URL if you are running the code off of the server
    //	private static final String ORACLE_URL = "jdbc:oracle:thin:@dbhost.students.cs.ubc.ca:1522:stu";
    // Use this version of the ORACLE_URL if you are tunneling into the undergrad servers
    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";

    private Connection connection = null;

    public DatabaseConnectionHandler() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            }
        }
    }

    public void delete(ModelType type, String primaryKey) {
        switch (type) {
            case DRIVES -> {

            }
            case TRIP -> {
                TripHandler tripHandler = new TripHandler(this);
                tripHandler.delete(primaryKey);
            }
            case ROUTE -> {

            }
            case MANAGES -> {

            }
            case STATION -> {
                StationHandler stationHandler = new StationHandler(this);
                stationHandler.delete(primaryKey);
            }
            case EMPLOYEE -> {

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
                storedAtHandler.delete(primaryKey);
            }
            case TRAIN_EXTRA -> {
                Train_ExtraHandler train_extraHandler = new Train_ExtraHandler(this);
                train_extraHandler.delete(primaryKey);
            }
            case TRAIN_MAIN -> {
                Train_MainHandler train_mainHandler = new Train_MainHandler(this);
                train_mainHandler.delete(primaryKey);
            }
            case GOES_THROUGH -> {

            }
            case CARGO_BELONGS_TO -> {

            }
            default -> {
                // no-op
            }
        }
    }

    public void insert(Model model) {
        switch (model.type) {
            case DRIVES -> {

            }
            case TRIP -> {
                TripHandler tripHandler = new TripHandler(this);
                tripHandler.insert(model);
            }
            case ROUTE -> {

            }
            case MANAGES -> {

            }
            case STATION -> {
                StationHandler stationHandler = new StationHandler(this);
                stationHandler.insert(model, connection);
            }
            case EMPLOYEE -> {

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
                storedAtHandler.insert(model);
            }
            case TRAIN_EXTRA -> {
                Train_ExtraHandler train_extraHandler = new Train_ExtraHandler(this);
                train_extraHandler.insert(model);
            }
            case TRAIN_MAIN -> {
                Train_MainHandler train_mainHandler = new Train_MainHandler(this);
                train_mainHandler.insert(model);
            }
            case GOES_THROUGH -> {

            }
            case CARGO_BELONGS_TO -> {

            }
            default -> {
                // no-op
            }
        }
    }

    public Model[] getInfo(ModelType type) {
        switch (type) {
            case DRIVES -> {

            }
            case TRIP -> {
                TripHandler tripHandler = new TripHandler(this);
                tripHandler.getInfo();
            }
            case ROUTE -> {

            }
            case MANAGES -> {

            }
            case STATION -> {
                StationHandler stationHandler = new StationHandler(this);
                stationHandler.getInfo();
            }
            case EMPLOYEE -> {

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
                storedAtHandler.getInfo();
            }
            case TRAIN_EXTRA -> {
                Train_ExtraHandler train_extraHandler = new Train_ExtraHandler(this);
                train_extraHandler.getInfo();
            }
            case TRAIN_MAIN -> {
                Train_MainHandler train_mainHandler = new Train_MainHandler(this);
                train_mainHandler.getInfo();
            }
            case GOES_THROUGH -> {

            }
            case CARGO_BELONGS_TO -> {

            }
            default -> {
                // no-op
            }
        }
        return null;
    }

    public void update(Model model, String primaryKey) {
        switch (model.type) {
            case DRIVES -> {

            }
            case TRIP -> {
                TripHandler tripHandler = new TripHandler(this);
                tripHandler.update(model, primaryKey);
            }
            case ROUTE -> {

            }
            case MANAGES -> {

            }
            case STATION -> {
                StationHandler stationHandler = new StationHandler(this);
                stationHandler.update(model, primaryKey);
            }
            case EMPLOYEE -> {

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
                storedAtHandler.update(model, primaryKey);
            }
            case TRAIN_EXTRA -> {
                Train_ExtraHandler train_extraHandler = new Train_ExtraHandler(this);
                train_extraHandler.update(model, primaryKey);
            }
            case TRAIN_MAIN -> {
                Train_MainHandler train_mainHandler = new Train_MainHandler(this);
                train_mainHandler.update(model, primaryKey);
            }
            case GOES_THROUGH -> {

            }
            case CARGO_BELONGS_TO -> {

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
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

//    public Connection getConnection() {
//        return connection;
//    }
//
    public static String getExceptionTag() {
        return EXCEPTION_TAG;
    }

    public static String getWarningTag() {
        return WARNING_TAG;
    }
}
