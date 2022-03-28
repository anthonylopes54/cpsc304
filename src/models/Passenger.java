package models;

import util.ModelType;

public class Passenger extends Model {
    private final int passengerID;
    private final String name;

    public Passenger(int passengerID, String name) {
        this.passengerID = passengerID;
        this.name = name;
        this.type = ModelType.PASSENGER;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public String getName() {
        return name;
    }
}
