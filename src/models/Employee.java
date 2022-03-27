package models;

import constants.ModelType;

import java.util.Date;

public class Employee extends Model{
    private final int empID;
    private final String name;
    private final Date date;

    private final String email;
    private final int salary;
    private final String specialization;
    private final int freightCar;
    private final Date licenseExpiryDate;
    private final int licenseNumber;
    private final Date certificationIssueDate;

    public Employee(int empID, String name, Date date, String email, int salary,
                    String specialization, int freightCar, Date licenseExpiryDate,
                    int licenseNumber, Date certificationIssueDate) {

        this.empID = empID;
        this.name = name;
        this.date = date;
        this.email = email;
        this.salary = salary;
        this.specialization = specialization;
        this.freightCar = freightCar;
        this.licenseExpiryDate = licenseExpiryDate;
        this.licenseNumber = licenseNumber;
        this.certificationIssueDate = certificationIssueDate;
        this.type = ModelType.EMPLOYEE;
    }

    public int getEmpID() {
        return empID;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public int getSalary() {
        return salary;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getFreightCar() {
        return freightCar;
    }

    public Date getLicenseExpiryDate() {
        return licenseExpiryDate;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public Date getCertificationIssueDate() {
        return certificationIssueDate;
    }

}
