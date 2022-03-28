package database;

import models.Model;

import java.sql.Connection;

public interface ModelHandler {
    void Insert(Model model, Connection connection);
    void update(Model model, int id, Connection connection);
    void delete(int id, Connection connection);
    Model[] getInfo(Connection connection);
}
