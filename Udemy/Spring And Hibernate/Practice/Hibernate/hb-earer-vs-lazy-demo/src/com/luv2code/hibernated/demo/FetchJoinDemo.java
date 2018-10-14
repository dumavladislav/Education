package com.luv2code.hibernated.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernated.demo.entity.Course;
import com.luv2code.hibernated.demo.entity.Instructor;
import com.luv2code.hibernated.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			// Option 2: Hibernate query with HQL
			
			// get the instructor
			
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
							+ "JOIN FETCH i.courses "
							+ "where i.id=:theInstructorId", 
							Instructor.class);
			
			// set parameter on query
			query.setParameter("theInstructorId", 1);
			
			// execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("dumavla: Instructor: " + tempInstructor);
			
			//commit the transaction
			session.getTransaction().commit();
			
			//close the session
			session.close();
			
			System.out.println("\ndumavla: The session is now closed!\n");
			
			System.out.println("dumavla: Courses: " + tempInstructor.getCourses());			
			
			System.out.println("dumavla: Done!");
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
