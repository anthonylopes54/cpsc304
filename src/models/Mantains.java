package models;

public class Mantains {
    private final int empID;
    private final int trainID;

    public Mantains(int empID, int trainID) {
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
