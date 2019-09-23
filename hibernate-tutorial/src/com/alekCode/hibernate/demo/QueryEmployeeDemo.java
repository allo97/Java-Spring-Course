package com.alekCode.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.alekCode.hibernate.entity.Employee;
import com.alekCode.hibernate.entity.Student;

public class QueryEmployeeDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start transaction
			session.beginTransaction();

			//query the students
			List<Employee> employees = session.createQuery("from Employee s where s.company= 'Aptiv'").getResultList();
			displayEmployees(employees);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

	private static void displayEmployees(List<Employee> employees) {
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

}
