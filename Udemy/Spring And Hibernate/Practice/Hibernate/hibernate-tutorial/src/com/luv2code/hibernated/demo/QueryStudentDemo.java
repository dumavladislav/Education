package com.luv2code.hibernated.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernated.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java Object
		
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();

			// display students			
			displayStudents(theStudents);
			
			// query students: lastName='Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			// display students
			System.out.println("Display students with lastName=Doe");
			displayStudents(theStudents);
			
			// query students: lastName='Doe' OR firstName='Daffy'
			theStudents = 
					session.createQuery("from Student s where"
							+ " s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
			
			System.out.println("\n\nDisplay students with lastName=Doe OR firstName='Daffy'");
			displayStudents(theStudents);
			
			// query students where email like '%gmail.com'
			System.out.println("\n\nDisplay students where email like '%gmail.com'");
			theStudents = session.createQuery("from Student s where"
							+ " s.email LIKE '%gmail.com'").getResultList(); 
			displayStudents(theStudents);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
