package database;

import models.Model;

import java.sql.Connection;

public interface ModelHandler {
    void Insert(Model model, Connection connection);
    void update(Model model, Connection connection);
    void delete(Model model, Connection connection);
    Model[] getInfo(Connection connection);
}
