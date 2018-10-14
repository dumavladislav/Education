package com.luv2code.hibernated.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernated.demo.entity.InstructorDetail;
import com.luv2code.hibernated.demo.entity.Course;
import com.luv2code.hibernated.demo.entity.Instructor;

public class CreateCoursesDemo {

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
			System.out.println(tempInstructor);
			
			// create courses
			
			Course course1 = new Course("Java for beginners");
			Course course2 = new Course("C++ for advanced developers");
			Course course3 = new Course("ReactJS basics");
			
			// assign courses to the instructor
			
			tempInstructor.add(course1);
			tempInstructor.add(course2);
			tempInstructor.add(course3);
			
			session.save(course1);
			session.save(course2);
			session.save(course3);
						

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
