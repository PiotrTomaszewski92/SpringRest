package com.spring.dao;
import com.spring.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //create a query - sort by last name
        Query<Customer> query = currentSession.createQuery("FROM Customer ORDER BY lastName",Customer.class);
        //execute query and get result list
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public Customer getCustomer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        //read from database using the primary key
        Customer customer = currentSession.get(Customer.class,id);
        return customer;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        //delete object with primary key
        Query query = currentSession.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId",id);
        query.executeUpdate();

    }
}


