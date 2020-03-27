package com.alekCode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.alekCode.hibernate.entity.Course;
import com.alekCode.hibernate.entity.Instructor;
import com.alekCode.hibernate.entity.InstructorDetail;
import com.alekCode.hibernate.entity.Review;
import com.alekCode.hibernate.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {
		
		//create session factory
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.addAnnotatedClass(Course.class)
													.addAnnotatedClass(Review.class)
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			// get the student mary from database
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			System.out.println("Loaded student " + tempStudent);
			System.out.println("Courses " + tempStudent.getCourses());
			
			// create more courses
			Course tempCourse1 = new Course("Rubik Cube course");
			Course tempCourse2 = new Course("Atari Game Development");

			// add student to courses
			
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			// save the courses
			System.out.println("Saving the courses");
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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
