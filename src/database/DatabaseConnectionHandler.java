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

            }
            case ROUTE -> {

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
        return null;
    }

    public void update(Model modal, int id) {
        switch (modal.type) {
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
