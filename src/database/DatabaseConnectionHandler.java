package database;

import constants.ModelType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public void delete(ModelType type) {
        switch (type) {
            case DRIVES -> {

            }
            case TRIP -> {

            }
            case ROUTE -> {

            }
            case MANAGES -> {

            }
            case STATION -> {

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

            }
            case TRAIN_EXTRA -> {

            }
            case TRAIN_MAIN_INFO -> {

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

    public void insert(ModelType type) {
        switch (type) {
            case DRIVES -> {

            }
            case TRIP -> {

            }
            case ROUTE -> {

            }
            case MANAGES -> {

            }
            case STATION -> {

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

            }
            case TRAIN_EXTRA -> {

            }
            case TRAIN_MAIN_INFO -> {

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

    public void get(ModelType type) {
        switch (type) {
            case DRIVES -> {

            }
            case TRIP -> {

            }
            case ROUTE -> {

            }
            case MANAGES -> {

            }
            case STATION -> {

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

            }
            case TRAIN_EXTRA -> {

            }
            case TRAIN_MAIN_INFO -> {

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

    public void update(ModelType type) {
        switch (type) {
            case DRIVES -> {

            }
            case TRIP -> {

            }
            case ROUTE -> {

            }
            case MANAGES -> {

            }
            case STATION -> {

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

            }
            case TRAIN_EXTRA -> {

            }
            case TRAIN_MAIN_INFO -> {

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
}
