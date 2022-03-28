package models;

import util.ModelType;

import java.sql.Date;
import java.sql.Timestamp;

public class Route extends Model{
    private final int routeID;
    private final String departureStation;
    private final String destinationStation;
    private final int tripDistance;
    private final int estimatedDuration;
    private final Timestamp departureTime;

    public Route(int routeID, String departureStation, String destinationStation, int tripDistance,
                 int estimatedDuration, Timestamp departureTime) {
        this.routeID = routeID;
        this.departureStation = departureStation;
        this.destinationStation = destinationStation;
        this.tripDistance = tripDistance;
        this.estimatedDuration = estimatedDuration;
        this.departureTime = departureTime;
        this.type = ModelType.ROUTE;

    }

    public int getRouteID() {
        return this.routeID;
    }

    public String getDepartureStation() {
        return this.departureStation;
    }

    public String getDestinationStation() {
        return this.destinationStation;
    }

    public int getTripDistance() {
        return this.tripDistance;
    }

    public int getEstimatedDuration() {
        return this.estimatedDuration;
    }

    public Timestamp getDepartureTime() {
        return this.departureTime;
    }
}
