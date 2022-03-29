package models;

import util.ModelType;

public class Maintains extends Model {
    private final int empID;
    private final int trainID;

    public Maintains(int empID, int trainID) {
        this.empID = empID;
        this.trainID = trainID;
        this.type = ModelType.MAINTAINS;
    }

    public int getEmpID() {
        return empID;
    }

    public int getTrainID() {
        return trainID;
    }
}
