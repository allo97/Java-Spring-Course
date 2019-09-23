package com.alekCode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.alekCode.hibernate.entity.Employee;
import com.alekCode.hibernate.entity.Student;

public class DeleteEmployeeDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			int employeeId = 1;
			
			//get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + employeeId);
		
			
			//delete student id=2
			System.out.println("Deleting student where id = 2");
			
			session.createQuery("delete from Employee where id=2").executeUpdate();
			//commit the transaction
			
			session.getTransaction().commit();
			
			
			
			
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
