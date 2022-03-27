package models;

public class Station {
    private final String name;
    private final String address;

    public Station(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
