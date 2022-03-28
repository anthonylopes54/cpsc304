package database;

import models.Model;
import models.Station;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ca.ubc.cs304.util.PrintablePreparedStatement;

public class StationHandler implements ModelHandler {
    private final DatabaseConnectionHandler dbHandler;
//    private final Connection connection;
    private static final String EXCEPTION_TAG = DatabaseConnectionHandler.getExceptionTag();
    private static final String WARNING_TAG = DatabaseConnectionHandler.getWarningTag();

    public StationHandler(DatabaseConnectionHandler dbHandler) {
        this.dbHandler = dbHandler;
//        this.connection = dbHandler.getConnection();
    }

    @Override
    public void insert(Model model, Connection connection) {
        Station station = (Station) model;

        try {
            String query = "INSERT INTO Station VALUES (?,?)";
            PrintablePreparedStatement ps = new PrintablePreparedStatement(connection.prepareStatement(query), query, false);
            ps.setString(1, station.getName());
            ps.setString(2, station.getAddress());

            ps.executeUpdate();
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            dbHandler.rollbackConnection();
        }
    }

    // primaryKey: name
    @Override
    public void update(Model model, Connection connection) {
        // TODO
    }

    @Override
    public void delete(Model model, Connection connection) {
        Station station = (Station) model;
        String name = station.getName();

        try {
            String query = "DELETE FROM Station WHERE name = ?";
            PrintablePreparedStatement ps = new PrintablePreparedStatement(connection.prepareStatement(query), query, false);
            ps.setString(1, name);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println(WARNING_TAG + " Station '" + name + "' does not exist!");
            }

            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            dbHandler.rollbackConnection();
        }
    }

    @Override
    public Model[] getInfo(Connection connection) {
        ArrayList<Station> result = new ArrayList<>();

        try {
            String query = "SELECT * FROM Station";
            PrintablePreparedStatement ps = new PrintablePreparedStatement(connection.prepareStatement(query), query, false);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Station station = new Station(
                        rs.getString("name"),
                        rs.getString("address"));
                result.add(station);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new Station[result.size()]);
    }
}
