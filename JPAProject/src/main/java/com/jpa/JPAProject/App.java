package com.jpa.JPAProject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	public static void main(String[] args) {

		Employee e = new Employee();
		e.setEmployeeId(102);
		e.setEmployeeName("Ajay");
		e.setEmpSalary(4500);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(e);

		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
