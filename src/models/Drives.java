package models;

public class Drives {

    private final int empID;
    private final int trainID;

    public Drives(int empID, int trainID) {
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
