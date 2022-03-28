package models;

import util.ModelType;

public class Train_MainInfo extends Model {

    private final int trainID;
    private final String model;
    private final int manufactureYear;

    public Train_MainInfo(int trainID, String model, int manufactureYear) {
        this.trainID = trainID;
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.type = ModelType.TRAIN_MAIN_INFO;
    }

    public int getTrainID() {
        return trainID;
    }

    public String getModel() {
        return model;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

}
