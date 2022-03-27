package models;

public class Manages {

    private final int empID;
    private final int trainID;

    public Manages(int empID, int trainID) {
        this.empID = empID;
        this.trainID = trainID;
    }
    public int getEmpID() {
        return empID;
    }

    public int getTrainID() {
        return trainID;
    }
}
