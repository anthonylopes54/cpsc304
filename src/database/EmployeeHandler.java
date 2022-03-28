package database;

import models.Employee;
import models.Model;
import util.Constants;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeHandler implements ModelHandler {
    @Override
    public void Insert(Model model, Connection connection) {
        Employee employee = (Employee) model;
        String query = "INSERT INTO Employee VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, employee.getEmpID());
            ps.setString(2, employee.getName());
            ps.setDate(3, (Date) employee.getDate());
            ps.setString(4, employee.getEmail());
            ps.setInt(5, employee.getSalary());
            ps.setString(6, employee.getSpecialization());
            ps.setInt(7, employee.getFreightCar());
            ps.setDate(8, (Date) employee.getLicenseExpiryDate());
            ps.setInt(9, employee.getLicenseNumber());
            ps.setDate(10, (Date) employee.getCertificationIssueDate());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    @Override
    public void update(Model modal, Connection connection) {

    }

    @Override
    public void delete(Model model, Connection connection) {
        Employee employee = (Employee) model;
        String query = "DELETE FROM Employee WHERE empID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, employee.getEmpID());
            int numOfRows = ps.executeUpdate();
            if (numOfRows == 0) {
                System.out.println(
                        Constants.WARNING_TAG +
                                " Employee {empID: " +
                                employee.getEmpID() +
                                "} does not exist!"
                );
            }
            connection.commit();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    @Override
    public Model[] getInfo(Connection connection) {
        return new Model[0];
    }
}
