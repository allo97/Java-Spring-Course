package com.alekCode.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.alekCode.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start transaction
			session.beginTransaction();
			
			//query the students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display the students
			displayStudents(theStudents);
			
			//query students: lastName = "Doe"
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			//display students
			
			System.out.println("\n\nStudents who have last name Doe");
			displayStudents(theStudents);
			
			//query the students
			
			theStudents = session.createQuery("from Student s where s.lastName = 'Doe' OR s.firstName = 'Daffy'").getResultList();
			
			//display students
			System.out.println("\nfrom Student s where s.lastName = 'Doe' OR s.firstName = 'Daffy'");
			displayStudents(theStudents);
			
			//query the Students where email like 'alekCode.com'
			
			theStudents = session.createQuery("from Student s where s.email like '%alekCode.com'").getResultList();
			
			//displayStudents
			System.out.println("\nfrom Student s where s.email like '%alekCode.com'");
			displayStudents(theStudents);
		
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
