package database;

import models.Cargo_BelongsTo;
import models.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cargo_BelongsToHandler implements ModelHandler {
    @Override
    public void Insert(Model model, Connection connection) {
        Cargo_BelongsTo cbt = (Cargo_BelongsTo) model;
        String query = "INSERT INTO cargo_belongsTo VALUES (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, cbt.getPassengerID());
            ps.setInt(2, cbt.getCargoID());
            ps.setInt(3, cbt.getWeight());
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
