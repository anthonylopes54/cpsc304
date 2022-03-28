package models;

import util.ModelType;

public class Seat_CarMapping extends Model {
    private final int seatNum;
    private final int carNum;

    public Seat_CarMapping(int seatNum, int carNum) {
        this.seatNum = seatNum;
        this.carNum = carNum;
        this.type = ModelType.SEAT_CAR_MAPPING;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public int getCarNum() {
        return carNum;
    }
}
