package com.alekCode.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.alekCode.hibernate.entity.Instructor;
import com.alekCode.hibernate.entity.InstructorDetail;
import com.alekCode.hibernate.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//get instructor detail by primary key
			int theId = 7;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class,  theId);
			
			//print instructor details
			System.out.println("Found instructor details: " + tempInstructorDetail);
			
			//print instructor details
			System.out.println("Found instructor associated with above details: " + tempInstructorDetail.getInstructor());
			
			//delete the instructor detail
			System.out.println("Deleting tempInstructorDetail " + tempInstructorDetail );
			
			// remove the associated object reference
			// break bi-directional link
			tempInstructorDetail.getInstructor().setInstructor_detail(null);
			session.delete(tempInstructorDetail);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} catch(Exception exc) {
			exc.printStackTrace();
		} finally {
			// handle connection leak issue
			
			session.close();
			factory.close();
		}
	}

}
