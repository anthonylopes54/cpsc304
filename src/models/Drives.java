package models;

import util.ModelType;

public class Drives extends Model{

    private final int empID;
    private final int trainID;

    public Drives(int empID, int trainID) {
        this.empID = empID;
        this.trainID = trainID;
        this.type = ModelType.DRIVES;
    }

    public int getEmpID() {
        return empID;
    }

    public int getTrainID() {
        return trainID;
    }

}
