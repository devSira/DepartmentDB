/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package departmentdb;

import java.util.List;
import model.Employee;
import model.EmployeeTable;

/**
 *
 * @author Siraphob.B
 */
public class DepartmentReport {
    public static void main(String[] args) {
        List<Employee> employee1 = EmployeeTable.findAllEmployee();
        System.out.println();
        System.out.println("All employee (by ID)");
        System.out.println("----------------------------");
        employee1.forEach(emp -> {
            System.out.println("ID: " + emp.getEmployeeid());
            System.out.println("Name: " + emp.getName());
            System.out.println("Job: " + emp.getJob());
            System.out.println("Salary: " + emp.getSalary());
            System.out.println("Department: " + emp.getDepartmentid().getName());
            System.out.println("----------------------------");
        });
        
        System.out.println();
        System.out.println("All employee (by Department)");
        System.out.println("----------------------------");
        System.out.println("Department ID: 1 Department Name: IT");
        System.out.println("----------------------------");
        employee1.forEach(emp -> {
            if(emp.getDepartmentid().getName().equals("IT")) {
                System.out.println("ID: " + emp.getEmployeeid());
                System.out.println("Name: " + emp.getName());
                System.out.println("Job: " + emp.getJob());
                System.out.println("Salary: " + emp.getSalary());
                System.out.println("----------------------------");
            }            
        });
        System.out.println();
        System.out.println("Department ID: 2 Department Name: HR");
        System.out.println("----------------------------");
        employee1.forEach(emp -> {
            if(emp.getDepartmentid().getName().equals("HR")) {
                System.out.println("ID: " + emp.getEmployeeid());
                System.out.println("Name: " + emp.getName());
                System.out.println("Job: " + emp.getJob());
                System.out.println("Salary: " + emp.getSalary());
                System.out.println("----------------------------");
            }            
        });
    }
}
