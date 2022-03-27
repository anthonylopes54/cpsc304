package models;

public class Passenger {
    private final int passengerID;
    private final String name;

    public Passenger(int passengerID, String name) {
        this.passengerID = passengerID;
        this.name = name;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public String getName() {
        return name;
    }
}
