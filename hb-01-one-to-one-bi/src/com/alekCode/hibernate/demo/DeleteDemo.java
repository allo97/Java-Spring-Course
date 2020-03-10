package com.alekCode.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.alekCode.hibernate.entity.Instructor;
import com.alekCode.hibernate.entity.InstructorDetail;
import com.alekCode.hibernate.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//get instructor by primary key
			int theId = 5;
			Instructor tempInstructor = session.get(Instructor.class,  theId);
			
			System.out.println("Found instructor: " + tempInstructor);
			
			//delete the instructors
			if(tempInstructor !=null) {
				System.out.println("Deleting: " + tempInstructor);
			}
			
			// Note: will ALSO delete associated "details" object
			//because of CascaseType.ALL
			//
			session.delete(tempInstructor);
			
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
