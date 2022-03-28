package database;

import models.Manages;
import models.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ManagesHandler implements ModelHandler {

    @Override
    public void Insert(Model model, Connection connection) {
        Manages manages = (Manages) model;
        String query = "INSERT INTO manages VALUES (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, manages.getEmpID());
            ps.setInt(2, manages.getTrainID());
            ps.executeUpdate();
            connection.commit();
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
