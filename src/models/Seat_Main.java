package models;

import util.ModelType;

public class Seat_Main extends Model {
    private final int seatNum;
    private final int trainID;
    private final String class_;

    public Seat_Main(int seatNum, int trainID, String class_) {
        this.seatNum = seatNum;
        this.trainID = trainID;
        this.class_ = class_;
        this.type = ModelType.SEAT_MAIN;

    }

    public int getSeatNum() {
        return seatNum;
    }

    public int getTrainID() {
        return trainID;
    }

    public String getClass_() {
        return class_;
    }
}
