package database;

import models.Model;
import models.Train_Extra;
import oracle.jdbc.proxy.annotation.Pre;
import util.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Train_ExtraHandler implements ModelHandler {
    private final DatabaseConnectionHandler dbHandler;

    public Train_ExtraHandler(DatabaseConnectionHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    @Override
    public void insert(Model model, Connection connection) {
        Train_Extra train_extra = (Train_Extra) model;

        try {
            String query = "INSERT INTO Train_Extra VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, train_extra.getModel());
            ps.setInt(2, train_extra.getManufactureYear());
            ps.setInt(3, train_extra.getNumSeats());
            ps.setInt(4, train_extra.getNumCars());

            ps.executeUpdate();
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
            dbHandler.rollbackConnection();
        }
    }

    // primary key: (model, manufactureYear)
    @Override
    public void update(Model model, Connection connection) {
        Train_Extra train_extra = (Train_Extra) model;
        String trainModel = train_extra.getModel();
        int manufactureYear = train_extra.getManufactureYear();
        int numSeats = train_extra.getNumSeats();
        int numCars = train_extra.getNumCars();

        try {
            String query = "UPDATE Train_Extra SET numSeats = ?, numCars = ? WHERE model = ? AND manufactureYear = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(3, trainModel);
            ps.setInt(4, manufactureYear);
            ps.setInt(1, numSeats);
            ps.setInt(2, numCars);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println(Constants.WARNING_TAG + " Train_Extra {model: " + trainModel + ", manufactureYear = " + manufactureYear + "} does not exist!");
            }

            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
            dbHandler.rollbackConnection();
        }
    }

    // primary key: (model, manufactureYear)
    @Override
    public void delete(Model model, Connection connection) {
        Train_Extra train_extra = (Train_Extra) model;
        String trainModel = train_extra.getModel();
        int manufactureYear = train_extra.getManufactureYear();

        try {
            String query = "DELETE FROM Train_Extra WHERE (model, manufactureYear) = (?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, trainModel);
            ps.setInt(2, manufactureYear);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println(Constants.WARNING_TAG + " Train_Extra {model: " + trainModel + ", manufactureYear = " + manufactureYear + "} does not exist!");
            }

            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
            dbHandler.rollbackConnection();
        }
    }

    @Override
    public Model[] getInfo(Connection connection) {
        ArrayList<Train_Extra> result = new ArrayList<>();

        try {
            String query = "SELECT * FROM Train_Extra";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Train_Extra train_extra = new Train_Extra(
                        rs.getString("model"),
                        rs.getInt("manufactureYear"),
                        rs.getInt("numSeats"),
                        rs.getInt("numCars"));
                result.add(train_extra);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new Train_Extra[result.size()]);
    }
}
