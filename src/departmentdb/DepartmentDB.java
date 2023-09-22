/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package departmentdb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Department;
import model.DepartmentTable;
import model.Employee;
import model.EmployeeTable;

/**
 *
 * @author Siraphob.B
 */
public class DepartmentDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Department department1 = new Department("IT");
        Department department2 = new Department("HR");
        DepartmentTable.insertDepartment(department1);
        DepartmentTable.insertDepartment(department2);
        Department departmentIT = DepartmentTable.findDepartmentByName("IT");
        Department departmentHR = DepartmentTable.findDepartmentByName("HR");
        if (departmentIT != null && departmentHR != null) {
            System.out.println(departmentIT);
            System.out.println(departmentHR);
        }
        Employee employee1 = new Employee("John", "Network Admin", 56789, departmentIT);
        Employee employee2 = new Employee("Marry", "HR Manager", 46789, departmentHR);
        Employee employee3 = new Employee("Henry", "Programmer", 67890, departmentIT);
        Employee employee4 = new Employee("Clark", "HR Recruiter", 36789, departmentHR);
        EmployeeTable.insertEmployee(employee1);
        EmployeeTable.insertEmployee(employee2);
        EmployeeTable.insertEmployee(employee3);
        EmployeeTable.insertEmployee(employee4);
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentdbPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
