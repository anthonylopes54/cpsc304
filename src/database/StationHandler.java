package database;

import models.Model;
import models.Station;

public class StationHandler implements ModelHandler {
    @Override
    public void insert(Model model) {
        model = (Station) model;
    }

    @Override
    public void update(Model model, int id) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Model[] getInfo() {
        return new Model[0];
    }
}
