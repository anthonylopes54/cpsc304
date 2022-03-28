package database;

import models.Cargo_BelongsTo;
import models.Model;
import util.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cargo_BelongsToHandler implements ModelHandler {
    @Override
    public void Insert(Model model, Connection connection) {
        Cargo_BelongsTo cbt = (Cargo_BelongsTo) model;
        String query = "INSERT INTO Cargo_BelongsTo VALUES (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, cbt.getPassengerID());
            ps.setInt(2, cbt.getCargoID());
            ps.setInt(3, cbt.getWeight());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    @Override
    public void update(Model model, Connection connection) {
        Cargo_BelongsTo cbt = (Cargo_BelongsTo) model;
        String query = "UPDATE Cargo_BelongsTo SET weight = ? WHERE passengerID = ? AND cargoID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, cbt.getWeight());
            ps.setInt(2, cbt.getPassengerID());
            ps.setInt(3, cbt.getCargoID());
            int numOfRows = ps.executeUpdate();
            if (numOfRows == 0) {
                System.out.println(
                        Constants.WARNING_TAG +
                                " Cargo_BelongsTo {empID: " +
                                cbt.getPassengerID() +
                                "; trainID: " +
                                cbt.getCargoID() +
                                "} does not exist!"
                );
            }
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    @Override
    public void delete(Model model, Connection connection) {
        Cargo_BelongsTo cbt = (Cargo_BelongsTo) model;
        String query = "DELETE FROM Cargo_BelongsTo WHERE passengerID = ? AND cargoID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, cbt.getPassengerID());
            ps.setInt(2, cbt.getCargoID());
            int numOfRows = ps.executeUpdate();
            if (numOfRows == 0) {
                System.out.println(
                        Constants.WARNING_TAG +
                                " Cargo_BelongsTo {empID: " +
                                cbt.getPassengerID() +
                                "; trainID: " +
                                cbt.getCargoID() +
                                "} does not exist!"
                );
            }
            connection.commit();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    @Override
    public Model[] getInfo(Connection connection) {
        ArrayList<Cargo_BelongsTo> res = new ArrayList<>();
        String query = "SELECT * FROM Cargo_BelongsTo";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                Cargo_BelongsTo cargo_belongsTo = new Cargo_BelongsTo(
                        Integer.parseInt(resultSet.getString("passengerID")),
                        Integer.parseInt(resultSet.getString("cargoID")),
                        Integer.parseInt(resultSet.getString("weight"))
                );
                res.add(cargo_belongsTo);
            }
            resultSet.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
        return res.toArray(new Cargo_BelongsTo[0]);
    }
}
