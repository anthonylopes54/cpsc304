package database;

import models.Drives;
import models.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DrivesHandler implements ModelHandler {
    @Override
    public void Insert(Model modal, Connection connection) {
        Drives drives = (Drives) modal;
        String query = "INSERT INTO drives VALUES (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, drives.getEmpID());
            ps.setInt(2, drives.getTrainID());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Model modal, int id, Connection connection) {

    }

    @Override
    public void delete(int id, Connection connection) {

    }

    @Override
    public Model[] getInfo(Connection connection) {
        return new Model[0];
    }
}
