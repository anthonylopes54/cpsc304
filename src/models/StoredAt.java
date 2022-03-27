package models;

public class StoredAt {
    private final int trainID;
    private final String stationName;

    public StoredAt(int trainID, String stationName) {
        this.trainID = trainID;
        this.stationName = stationName;
    }

    public int getTrainID() {
        return trainID;
    }

    public String getStationName() {
        return stationName;
    }
}
