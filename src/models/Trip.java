package models;

import util.ModelType;

public class Trip extends Model {
    private final int seatNum;
    private final int routeID;
    private final int passengerID;
    private final int trainID;

    public Trip(int seatNum, int routeID, int passengerID, int trainID) {
        this.seatNum = seatNum;
        this.routeID = routeID;
        this.passengerID = passengerID;
        this.trainID = trainID;
        this.type = ModelType.TRIP;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public int getRouteID() {
        return routeID;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public int getTrainID() {
        return trainID;
    }
}
