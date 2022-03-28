package models;

import util.ModelType;

import java.util.Date;

public class GoesThrough extends Model {
    private final String stationName;
    private final Date timeOfStop;
    private final int routeID;

    public GoesThrough(String stationName, Date timeOfStop, int routeID) {
        this.stationName = stationName;
        this.timeOfStop = timeOfStop;
        this.routeID = routeID;
        this.type = ModelType.GOES_THROUGH;
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
