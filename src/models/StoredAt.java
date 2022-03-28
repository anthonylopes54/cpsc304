package models;

import util.ModelType;

public class StoredAt extends Model {
    private final int trainID;
    private final String stationName;

    public StoredAt(int trainID, String stationName) {
        this.trainID = trainID;
        this.stationName = stationName;
        this.type = ModelType.STORED_AT;
    }

    public int getTrainID() {
        return trainID;
    }

    public String getStationName() {
        return stationName;
    }
}
