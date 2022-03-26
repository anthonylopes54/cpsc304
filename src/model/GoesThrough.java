package model;

import java.util.Date;

public class GoesThrough {
    private final String stationName;
    private final Date timeOfStop;
    private final int routeID;

    public GoesThrough(String stationName, Date timeOfStop, int routeID) {
        this.stationName = stationName;
        this.timeOfStop = timeOfStop;
        this.routeID = routeID;
    }

    public String getStationName() {
        return stationName;
    }

    public Date getTimeOfStop() {
        return timeOfStop;
    }

    public int getRouteID() {
        return routeID;
    }
}
