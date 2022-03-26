package model;

public class Seat_MainInfo {
    private final int seatNum;
    private final int trainID;
    private final String class_;

    public Seat_MainInfo(int seatNum, int trainID, String class_) {
        this.seatNum = seatNum;
        this.trainID = trainID;
        this.class_ = class_;
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
