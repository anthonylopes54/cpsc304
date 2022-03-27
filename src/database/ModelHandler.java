package database;

import models.Model;

public interface ModelHandler {
    void insert(Model model);
    void update(Model model, int id);
    void delete(int id);
    Model[] getInfo();
}
