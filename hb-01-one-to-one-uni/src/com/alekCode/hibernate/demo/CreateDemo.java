package com.alekCode.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.alekCode.hibernate.entity.Instructor;
import com.alekCode.hibernate.entity.InstructorDetail;
import com.alekCode.hibernate.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create the objects
			System.out.println("Creating new Instructor and InstructorDetail object...");
			
			/*Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv@code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.alekcode.com/youtube", "Love to code!!!");
			*/
			
			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv@code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.youtube.com", "Guitar");
			
			
			
			//associate the Objects
			tempInstructor.setInstructor_detail(tempInstructorDetail);
			
			//start a transaction
			session.beginTransaction();
			
			//save the instructor
			
			//Note this will ALSO save the detail objects because of CascadeType.ALL
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} catch(Exception exc) {
			exc.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
