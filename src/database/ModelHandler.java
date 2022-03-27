package database;

import models.Model;

public interface ModelHandler {
    void Insert(Model modal);
    void update(Model modal, int id);
    void delete(int id);
    Model[] getInfo();
}
