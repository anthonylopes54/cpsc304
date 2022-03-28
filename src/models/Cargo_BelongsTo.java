package models;

import util.ModelType;

public class Cargo_BelongsTo extends Model {
    private final int passengerID;
    private final int cargoID;
    private final int weight;

    public Cargo_BelongsTo(int passengerID, int cargoID, int weight) {
        this.passengerID = passengerID;
        this.cargoID = cargoID;
        this.weight = weight;
        this.type = ModelType.CARGO_BELONGS_TO;
    }

    public int getPassengerID() {
        return this.passengerID;
    }

    public int getCargoID() {
        return this.cargoID;
    }
    public int getWeight() {
        return this.weight;
    }
}
