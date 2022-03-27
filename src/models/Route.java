package models;

import java.sql.Date;

public class Route {
    private final int routeID;
    private final String departureStation;
    private final String destinationStation;
    private final int tripDistance;
    private final int estimatedDuration;
    private final Date departureTime;

    public Route(int routeID, String departureStation, String destinationStation, int tripDistance,
                 int estimatedDuration, Date departureTime) {
        this.routeID = routeID;
        this.departureStation = departureStation;
        this.destinationStation = destinationStation;
        this.tripDistance = tripDistance;
        this.estimatedDuration = estimatedDuration;
        this.departureTime = departureTime;
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

    public Date getDepartureTime() {
        return this.departureTime;
    }
}
