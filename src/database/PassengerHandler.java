package database;

import models.Model;

import java.sql.Connection;

public class PassengerHandler implements ModelHandler {
    @Override
    public void insert(Model model, Connection connection) {

    }

    @Override
    public void update(Model model, Connection connection) {

    }

    @Override
    public void delete(Model model, Connection connection) {

    }

    @Override
    public Model[] getInfo(Connection connection) {
        return new Model[0];
    }
}
