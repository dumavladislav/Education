package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // injection from spring-mvc-crud-demo-servlet.xml
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create the query
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

        // execute query and get results list
        List<Customer> customers = theQuery.getResultList();

        //return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();
        System.out.println(theCustomer.getId());
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Customer customer = currentSession.get(Customer.class, theId);
        return customer;
    }

    @Override
    public void deleteCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        //Customer theCustomer = currentSession.get(Customer.class, theId);
        Query query = currentSession.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", theId);
        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from Customer where firstName=coalesce(:firstName, firstName) and lastName=coalesce(:lastName, lastName) and email=coalesce(:email, email)");
        query.setParameter("firstName", theCustomer.getFirstName()!="" ? theCustomer.getFirstName() : null);
        query.setParameter("lastName", theCustomer.getLastName()!="" ? theCustomer.getLastName() : null);
        query.setParameter("email", theCustomer.getEmail()!="" ? theCustomer.getEmail() : null);
        return query.getResultList();
    }
}
