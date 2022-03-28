package database;

import models.Model;
import models.Seat_CarMapping;
import models.Seat_Main;
import util.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Seat_MainHandler implements ModelHandler{
    @Override
    public void Insert(Model model, Connection connection) {
        Seat_Main seat_main = (Seat_Main) model;
        String query = "INSERT INTO Seat_Main VALUES (?,?,?)";
        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1,seat_main.getSeatNum());
            ps.setInt(2, seat_main.getTrainID());
            ps.setString(3, seat_main.getClass_());


            ps.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    @Override
    public void update(Model model, Connection connection) {
        Seat_Main seat_main = (Seat_Main) model;
        String query = "UPDATE Seat_Main SET class = ?, WHERE seatNum = ? AND trainID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, seat_main.getClass_());
            ps.setInt(2,seat_main.getSeatNum());
            ps.setInt(3, seat_main.getTrainID());

            int numOfRows = ps.executeUpdate();
            if (numOfRows == 0) {
                System.out.println(
                        Constants.WARNING_TAG +
                                " Seat_main {seatNum: " +
                                seat_main.getSeatNum() + " AND trainID" +
                                seat_main.getTrainID() +
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
        Seat_Main seat_main = (Seat_Main) model;
        String query = "DELETE FROM Seat_Main WHERE seatNum = ? AND trainID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,seat_main.getSeatNum());
            ps.setInt(2, seat_main.getTrainID());

            int numOfRows = ps.executeUpdate();
            if (numOfRows == 0) {
                System.out.println(
                        Constants.WARNING_TAG +
                                " Seat_main {seatNum: " +
                                seat_main.getSeatNum() + " AND trainID: " +
                                seat_main.getTrainID() +
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
        ArrayList<Seat_Main> res = new ArrayList<>();
        String query = "SELECT * FROM Seat_car";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                Seat_Main seat_Main = new Seat_Main(
                        (resultSet.getInt("seatNum")),
                        (resultSet.getInt("trainID")),
                        resultSet.getString("class")
                );
                res.add(seat_Main);
            }
            resultSet.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
        return res.toArray(new Seat_Main[0]);

    }
}
