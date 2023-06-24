package com.capg.HibernateDemo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration = configuration.configure().addAnnotatedClass(Employee.class);
		
		SessionFactory sesionFactory = configuration.buildSessionFactory();
		Session session = sesionFactory.openSession();

		Transaction tx = session.beginTransaction();

		Employee employee1 = new Employee(103, "Yamini", 36500);
		session.save(employee1);
		
		tx.commit();
		session.close();
	}
}
