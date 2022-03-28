package database;

import models.Employee;
import models.Model;
import util.Constants;

import java.sql.*;
import java.util.ArrayList;

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
    public void update(Model model, Connection connection) {
        Employee employee = (Employee) model;
        String query = "UPDATE Employee SET name = ?, specialization = ?, salary = ?, dateOfBirth = ?, email = ?, freightCar = ?, licenseExpiryDate = ?, licenseNumber = ?, certificationIssueDate = ? WHERE empID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getSpecialization());
            ps.setInt(3, employee.getSalary());
            ps.setDate(4, (Date) employee.getDate());
            ps.setString(5, employee.getEmail());
            ps.setInt(6, employee.getFreightCar());
            ps.setDate(7, (Date) employee.getLicenseExpiryDate());
            ps.setInt(8, employee.getLicenseNumber());
            ps.setDate(9, (Date) employee.getCertificationIssueDate());
            ps.setInt(10, employee.getEmpID());
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
            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
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
        ArrayList<Employee> res = new ArrayList<>();
        String query = "SELECT * FROM Employee";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt("empID"),
                        resultSet.getString("name"),
                        resultSet.getDate("dateOfBirth"),
                        resultSet.getString("email"),
                        resultSet.getInt("salary"),
                        resultSet.getString("specialization"),
                        resultSet.getInt("freightCar"),
                        resultSet.getDate("licenseExpiryDate"),
                        resultSet.getInt("licenseNumber"),
                        resultSet.getDate("certificationIssueDate")
                );
                res.add(employee);
            }
            resultSet.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(Constants.EXCEPTION_TAG + " " + e.getMessage());
        }
        return res.toArray(new Employee[0]);
    }
}
