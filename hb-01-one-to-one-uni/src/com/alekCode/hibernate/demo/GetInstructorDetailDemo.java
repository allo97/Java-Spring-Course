package com.alekCode.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.alekCode.hibernate.entity.Instructor;
import com.alekCode.hibernate.entity.InstructorDetail;
import com.alekCode.hibernate.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//get Instruction details by Id
			int theId = 2;
			InstructorDetail instructor_detail = session.get(InstructorDetail.class, theId);
			
			//print the instructor details
			System.out.println("Instructor detail: " + instructor_detail);
			
			//print the instructor
			System.out.println("Associated Instructor: " + instructor_detail.getInstructor());
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} catch(Exception exc) {
			exc.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
