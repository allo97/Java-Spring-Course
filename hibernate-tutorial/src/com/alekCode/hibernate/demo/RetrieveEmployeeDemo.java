package com.alekCode.hibernate.demo;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.alekCode.hibernate.entity.Employee;
import com.alekCode.hibernate.entity.Student;

public class RetrieveEmployeeDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//get a new session and start transaction
			session.beginTransaction();
			
			//get all the students and show them
			List<Employee> employees = session.createQuery("from Employee").getResultList();
			displayEmployees(employees);
			
			//generate random number based on number of employees
			Random genRandom = new Random();
			int id = genRandom.nextInt(employees.size()) + 1;
			System.out.println("id = " + id);
			
			
			//retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + id);
			
			Employee myStudent = session.get(Employee.class, id);
			
			System.out.println("Get complete: " + myStudent);
			//commit the transaction
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}
	
	private static void displayEmployees(List<Employee> employees) {
		for(Employee employee : employees) {
			System.out.println(employee);
		}
	}

}
