package com.jbk.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jbk.springdemo.entity.Customer;

@Repository
public class customerDaoImpl implements CustomerDAO{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Customer> getCustomer() {
		Session session=sessionFactory.getCurrentSession();
		Query<Customer> thequery=session.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> customers=thequery.getResultList();
		return customers;
	}
	@Override
	public void savecustomer(Customer thecustomer) {
	Session session=sessionFactory.getCurrentSession();
	session.saveOrUpdate(thecustomer);
	}
	@Override
	public Customer getCustomers(int theid) {
		Session session=sessionFactory.getCurrentSession();
		Customer cust=session.get(Customer.class, theid);
		return cust ;
	}
	@Override
	public void deletecustomer(int theid) {
	
		Session session=sessionFactory.getCurrentSession();
		Query<Customer> thequery=session.createQuery("delete from Customer where id=:customerId");
		thequery.setParameter("customerId", theid);
		thequery.executeUpdate();
	}
	@Override
	public boolean checkuser(String userName, String password) {
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		//Query using Hibernate Query Language
		String SQL_QUERY =" from Customer as o where o.userName=:userName and o.password=:password";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter("userName",userName);
		query.setParameter("password",password);
		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			userFound= true;
		}

		session.close();
		return userFound;
		
	}
	@Override
	public boolean checkadmin(String userName, String password) {
		Session session = sessionFactory.openSession();
		boolean AdminFound = false;
		//Query using Hibernate Query Language
		String SQL_QUERY =" from Admin as o where o.userName=:userName and o.password=:password";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter("userName",userName);
		query.setParameter("password",password);
		List list = query.list();
		if ((list != null) && (list.size() > 0)) {
			AdminFound= true;
		}
		session.close();
		return AdminFound;
		
	}

	

}
