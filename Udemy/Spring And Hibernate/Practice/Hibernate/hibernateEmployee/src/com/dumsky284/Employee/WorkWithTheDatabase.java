package com.dumsky284.Employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dumsky284.Employee.Entity.Employee;

public class WorkWithTheDatabase {

	SessionFactory factory;
	
	WorkWithTheDatabase() {
		factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Employee.class)
				 .buildSessionFactory();
	}
	
	public static void main(String[] args) {
		
		WorkWithTheDatabase wwdb = new WorkWithTheDatabase();
		
		for(int i=0; i<10; i++) {
			Employee tempEmpl = new Employee("Ivan_"+i,"Petrov_"+i,"Romashka_"+i);
			wwdb.saveEmployee(tempEmpl);
		}
		
		int emplToGet = 7;
		System.out.println("Getting employee with id=" + emplToGet);
		System.out.println(wwdb.getEmployee(emplToGet));
		
		String companyToGet = "Ashan";
		System.out.println("Getting employees from company =" + companyToGet);
		List<Employee> employees = wwdb.getCompanyEmployees(companyToGet);
		for(Employee tempEmpl: employees) {
			System.out.println(tempEmpl);
		}

		int emplToDelete = 6;
		System.out.println("Deleting employee with id=" + emplToDelete);
		wwdb.deleteEmployee(emplToDelete);
	}
	
	public void saveEmployee(Employee employee) {
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		session.save(employee);
		
		session.getTransaction().commit();
		
	}
	
	public Employee getEmployee(int id) {
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Employee tempEmpl = session.get(Employee.class, id);
		session.getTransaction().commit();
		return tempEmpl;
	}
	
	public List<Employee> getCompanyEmployees(String company) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Employee> employees = session
				.createQuery("from Employee empl where empl.company = '"+company+"'")
				.getResultList();
		session.getTransaction().commit();
		return employees;
	}
	
	public void deleteEmployee(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		session.delete(session.get(Employee.class, id));
		session.getTransaction().commit();
	}

}
