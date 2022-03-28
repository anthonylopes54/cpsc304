package models;

import util.ModelType;

public class Manages extends Model {

    private final int empID;
    private final int trainID;

    public Manages(int empID, int trainID) {
        this.empID = empID;
        this.trainID = trainID;
        this.type = ModelType.MANAGES;
    }
    public int getEmpID() {
        return empID;
    }

    public int getTrainID() {
        return trainID;
    }
}
