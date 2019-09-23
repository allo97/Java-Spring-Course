package com.alekCode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.alekCode.hibernate.entity.Employee;

public class CreateEmployeeDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create a student object
			System.out.println("Creating new student object...");
			Employee tempStudent1 = new Employee("Alek", "Kaminski", "Aptiv");
			Employee tempStudent2 = new Employee("Marysia", "Stalec", "Comarch");
			Employee tempStudent3 = new Employee("Pawel", "Mleczko", "ABS");
			Employee tempStudent4 = new Employee("Kasia", "Kopaczka", "Solar power development");
			
			//start transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			session.save(tempStudent4);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
