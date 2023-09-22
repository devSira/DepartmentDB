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
import javax.persistence.Query;

/**
 *
 * @author Siraphob.B
 */
public class DepartmentTable {
    public static void insertDepartment(Department department) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentdbPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(department);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static Department findDepartmentById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentdbPU");
        EntityManager em = emf.createEntityManager();
        Department department = em.find(Department.class, id);
        em.close();
        return department;
    }

    public static Department findDepartmentByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DepartmentdbPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Department.findByName");
        query.setParameter("name", name);
        List<Department> department = (List<Department>) query.getResultList();
        em.close();
        return department.get(0);
    }
}
