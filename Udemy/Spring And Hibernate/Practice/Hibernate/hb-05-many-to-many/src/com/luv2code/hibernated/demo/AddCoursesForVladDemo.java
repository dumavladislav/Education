package com.luv2code.hibernated.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernated.demo.entity.Course;
import com.luv2code.hibernated.demo.entity.Instructor;
import com.luv2code.hibernated.demo.entity.InstructorDetail;
import com.luv2code.hibernated.demo.entity.Review;
import com.luv2code.hibernated.demo.entity.Student;

public class AddCoursesForVladDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Review.class)
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// get the student Vlad from the database
			Student vlad = session.get(Student.class, 1);
			
			System.out.println("\nLoaded Student: " + vlad);
			System.out.println("Student's courses: " + vlad.getCourses());
						
			// create more courses
			Course newCourse1 = new Course("Python And Anaconda");
			Course newCourse2 = new Course("C++ for dummy");
			
			// add student to courses
			
			newCourse1.addStudent(vlad);
			newCourse2.addStudent(vlad);
			
			// save the courses
			System.out.println("Saving the courses ... ");
			session.save(newCourse1);
			session.save(newCourse2);
			
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
