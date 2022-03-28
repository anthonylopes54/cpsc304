package database;

import models.Employee;
import models.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeHandler implements ModelHandler {
    @Override
    public void Insert(Model model, Connection connection) {
        Employee employee = (Employee) model;
        String query = "INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?,?)";
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
            e.printStackTrace();
        }
    }

    @Override
    public void update(Model modal, int id, Connection connection) {

    }

    @Override
    public void delete(int id, Connection connection) {

    }

    @Override
    public Model[] getInfo(Connection connection) {
        return new Model[0];
    }
}
