package model;

public class Seat_CarMapping {
    private final int seatNum;
    private final int carNum;

    public Seat_CarMapping(int seatNum, int carNum) {
        this.seatNum = seatNum;
        this.carNum = carNum;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public int getCarNum() {
        return carNum;
    }
}
