package models;

import util.ModelType;

public class Station extends Model {
    private final String name;
    private final String address;

    public Station(String name, String address) {
        this.name = name;
        this.address = address;
        this.type = ModelType.STATION;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
