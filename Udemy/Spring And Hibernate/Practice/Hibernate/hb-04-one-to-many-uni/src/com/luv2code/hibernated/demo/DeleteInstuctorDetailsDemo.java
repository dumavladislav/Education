package com.luv2code.hibernated.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernated.demo.entity.InstructorDetail;
import com.luv2code.hibernated.demo.entity.Instructor;

public class DeleteInstuctorDetailsDemo {

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
			
			// get the instuctor detail
			int theId=3;
			InstructorDetail tempInstrDet = session.get(InstructorDetail.class, theId);
			
			System.out.println("tempInstrDet: " + tempInstrDet);
			
			// print the associated instructor
			
			System.out.println("the associated instructor: " + tempInstrDet.getInstructor());
			
			// delete the instuctor detail
			System.out.println("Deleting inst details: " + tempInstrDet);
			
			// remove the associated object reference
			
			tempInstrDet.getInstructor().setInstructorDetail(null);
			
			session.delete(tempInstrDet);
			

			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
