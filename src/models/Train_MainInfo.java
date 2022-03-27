package models;

public class Train_MainInfo {

    private final int trainID;
    private final String model;
    private final int manufactureYear;

    public Train_MainInfo(int trainID, String model, int manufactureYear) {
        this.trainID = trainID;
        this.model = model;
        this.manufactureYear = manufactureYear;
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
