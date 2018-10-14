package com.luv2code.hibernated.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernated.demo.entity.Course;
import com.luv2code.hibernated.demo.entity.Instructor;
import com.luv2code.hibernated.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor
			
			Instructor tempInstructor = session.get(Instructor.class, 1);
			
			System.out.println("dumavla: Instructor: " + tempInstructor);
			
			System.out.println("dumavla: Courses: " + tempInstructor.getCourses());	
			
			//commit the transaction
			session.getTransaction().commit();
			
			//close the session
			session.close();
			
			System.out.println("\ndumavla: The session is now closed!\n");
			
			// since courses are lazy loaded ... this should fail
			
			// Option 1: call getter method while session is open. In this case the following line will read from the memory
			
			System.out.println("dumavla: Courses: " + tempInstructor.getCourses());			
			
			System.out.println("dumavla: Done!");
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
