package models;

import constants.ModelType;

public class Train_Extra extends Model {
    private final String model;
    private final int trainId;
    private final int numSeats;
    private final int numCars;

    public Train_Extra(String model, int trainId, int numSeats, int numCars) {
        this.model = model;
        this.trainId = trainId;
        this.numSeats = numSeats;
        this.numCars = numCars;
        this.type = ModelType.TRAIN_EXTRA;
    }

    public String getModel() {
        return model;
    }

    public int getTrainId() {
        return trainId;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public int getNumCars() {
        return numCars;
    }


}
