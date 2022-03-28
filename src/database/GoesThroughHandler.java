package database;

import models.GoesThrough;
import models.Model;

import java.sql.*;

public class GoesThroughHandler implements ModelHandler {
    @Override
    public void Insert(Model model, Connection connection) {
        GoesThrough goesThrough = (GoesThrough) model;
        String query = "INSERT INTO goesThrough VALUES (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, goesThrough.getStationName());
            ps.setTimestamp(2, (Timestamp) goesThrough.getTimeOfStop()); // TODO: Is this a timestamp?
            ps.setInt(3, goesThrough.getRouteID());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Model model, int id, Connection connection) {

    }

    @Override
    public void delete(int id, Connection connection) {

    }

    @Override
    public Model[] getInfo(Connection connection) {
        return new Model[0];
    }
}
