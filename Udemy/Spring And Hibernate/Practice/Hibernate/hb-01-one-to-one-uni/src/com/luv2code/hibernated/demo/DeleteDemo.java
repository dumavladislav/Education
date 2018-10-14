package com.luv2code.hibernated.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernated.demo.entity.InstructorDetail;
import com.luv2code.hibernated.demo.entity.Instructor;

public class DeleteDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
		
			// start a transaction
			session.beginTransaction();
			
			// get the instructor by primary key / id
			int theId=1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			
			if (tempInstructor != null) {
				System.out.println("Instructor to be deleted: " + tempInstructor);
				session.delete(tempInstructor);
			}
			
			// delete the instructor

			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
