package database;

import models.Model;

public interface ModelHandler {
    void insert(Model model);
    void update(Model model, String primaryKey);
    void delete(String primaryKey);
    Model[] getInfo();
}
