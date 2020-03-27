package com.alekCode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.alekCode.hibernate.entity.Course;
import com.alekCode.hibernate.entity.Instructor;
import com.alekCode.hibernate.entity.InstructorDetail;
import com.alekCode.hibernate.entity.Review;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.addAnnotatedClass(Course.class)
													.addAnnotatedClass(Review.class)
													.buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
		
			// get the course
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			//print the course
			System.out.println("Course " + tempCourse);
			
			
			//print the course reviews
			System.out.println("Reviews " + tempCourse.getReviews());
			
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
