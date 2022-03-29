package models;

import util.ModelType;

import java.sql.Timestamp;
import java.util.Date;

public class GoesThrough extends Model {
    private final String stationName;
    private final Timestamp timeOfStop;
    private final int routeID;

    public GoesThrough(String stationName, Timestamp timeOfStop, int routeID) {
        this.stationName = stationName;
        this.timeOfStop = timeOfStop;
        this.routeID = routeID;
        this.type = ModelType.GOES_THROUGH;
    }

    public String getStationName() {
        return stationName;
    }

    public Timestamp getTimeOfStop() {
        return timeOfStop;
    }

    public int getRouteID() {
        return routeID;
    }
}
