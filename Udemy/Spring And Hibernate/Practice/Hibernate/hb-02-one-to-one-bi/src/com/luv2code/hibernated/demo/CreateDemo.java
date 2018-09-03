package com.luv2code.hibernated.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernated.demo.entity.InstructorDetail;
import com.luv2code.hibernated.demo.entity.Instructor;

public class CreateDemo {

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
			
			// create the objects
			
			//Instructor tempInstructor = new Instructor("Vlad", "Duma", "dumsky284@mail.ru");
			//InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com/dumsky284", "Coding");
			
			Instructor tempInstructor = new Instructor("Ivan", "Grozev", "Grozev@mail.ru");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com/Grozev", "Talking");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
		
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			

			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
