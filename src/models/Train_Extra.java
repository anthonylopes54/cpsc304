package models;

import util.ModelType;

public class Train_Extra extends Model {
    private final String model;
    private final int manufactureYear;
    private final int numSeats;
    private final int numCars;

    public Train_Extra(String model, int manufactureYear, int numSeats, int numCars) {
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.numSeats = numSeats;
        this.numCars = numCars;
        this.type = ModelType.TRAIN_EXTRA;
    }

    public String getModel() {
        return model;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public int getNumCars() {
        return numCars;
    }


}
