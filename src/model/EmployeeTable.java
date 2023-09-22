/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Siraphob.B
 */
public class EmployeeTable {
    public static void insertEmployee(Employee employee) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentdbPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(employee);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static List<Employee> findAllEmployee() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentdbPU");
        EntityManager em = emf.createEntityManager();
        List<Employee> employeeList = (List<Employee>) em.createNamedQuery("Employee.findAll").getResultList();
        em.close();
        return employeeList;
    }
    public static List<Employee> findEmployeeByDepartmentId(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentdbPU");
        EntityManager em = emf.createEntityManager();
        List<Employee> employeeList = (List<Employee>) em.find(Department.class, id);
        em.close();
        return employeeList;
    }
}
