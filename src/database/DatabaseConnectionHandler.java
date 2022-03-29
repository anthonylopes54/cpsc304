package database;

import models.*;
import util.Constants;
import util.ModelType;

import java.sql.*;
import java.util.Date;

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
                RouteHandler routeHandler = new RouteHandler();
                routeHandler.Insert(model, connection);
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
                MaintainsHandler maintainsHandler = new MaintainsHandler();
                maintainsHandler.Insert(model, connection);

            }
            case PASSENGER -> {
                PassengerHandler passengerHandler = new PassengerHandler();
                passengerHandler.Insert(model, connection);

            }
            case SEAT_MAIN -> {
                Seat_MainHandler seat_mainHandler = new Seat_MainHandler();
                seat_mainHandler.Insert(model, connection);

            }
            case SEAT_CAR_MAPPING -> {
                Seat_CarMappingHandler seat_CarMappingHandler = new Seat_CarMappingHandler();
                seat_CarMappingHandler.Insert(model, connection);

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
                RouteHandler routeHandler = new RouteHandler();
                routeHandler.getInfo(connection);

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
                MaintainsHandler maintainsHandler = new MaintainsHandler();
                maintainsHandler.getInfo(connection);

            }
            case PASSENGER -> {
                PassengerHandler passengerHandler = new PassengerHandler();
                passengerHandler.getInfo(connection);

            }
            case SEAT_MAIN -> {
                Seat_MainHandler seat_mainHandler = new Seat_MainHandler();
                seat_mainHandler.getInfo(connection);
            }
            case SEAT_CAR_MAPPING -> {
                Seat_CarMappingHandler seat_CarMappingHandler = new Seat_CarMappingHandler();
                seat_CarMappingHandler.getInfo(connection);

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
                RouteHandler routeHandler = new RouteHandler();
                routeHandler.update(model, connection);
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
                MaintainsHandler maintainsHandler = new MaintainsHandler();
                maintainsHandler.update(model, connection);
            }
            case PASSENGER -> {
                PassengerHandler passengerHandler = new PassengerHandler();
                passengerHandler.update(model, connection);

            }
            case SEAT_MAIN -> {
                Seat_MainHandler seat_mainHandler = new Seat_MainHandler();
                seat_mainHandler.update(model, connection);

            }
            case SEAT_CAR_MAPPING -> {
                Seat_CarMappingHandler seat_CarMappingHandler = new Seat_CarMappingHandler();
                seat_CarMappingHandler.update(model, connection);

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

    public void addPassenger(int passengerID, String name) {
        // !TODO we could make handlers global instead of creating new instances each time we need to use them no?

        PassengerHandler ps = new PassengerHandler();
        Passenger newPassenger = new Passenger(passengerID, name);
        ps.Insert(newPassenger, connection);

    }

    public void deletePassenger(int passengerID) {

        PassengerHandler ps = new PassengerHandler();
        Passenger newPassenger = new Passenger(passengerID, "");
        ps.delete(newPassenger, connection);

    }

    public void updateEmployee(int empID, String name, java.util.Date date, String email, int salary,
                               String specialization, int freightCar, java.util.Date licenseExpiryDate,
                               int licenseNumber, Date certificationIssueDate) {

        EmployeeHandler eh = new EmployeeHandler();

        Employee newEmp = new Employee(empID, name, date, email, salary,
         specialization, freightCar, licenseExpiryDate,
         licenseNumber, certificationIssueDate);

        eh.update(newEmp, connection);

    }

    public String getTrainsByModel(String model) {

        String query = "SELECT trainID FROM Train WHERE model = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, model);
            ResultSet rs = ps.executeQuery();
            StringBuilder sb = new StringBuilder();

            while(rs.next()) {
                String statement = rs.getString("trainId") + ", ";
                sb.append(statement);
            }

            rs.close();
            ps.close();
            String result = "Train Ids: " + sb;
            // It's a subset to remove the last + ", "

            return result.substring(0, result.length()-2);

        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
            return null;
        }



    }


}
