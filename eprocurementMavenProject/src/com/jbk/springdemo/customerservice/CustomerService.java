package com.jbk.springdemo.customerservice;

import java.util.List;

import com.jbk.springdemo.entity.Customer;

public interface CustomerService {
	
 public List<Customer> getCustomer();

public void savecustomer(Customer thecustomer);

public Customer getCustomers(int theid);

public void delete(int theid);

public boolean checkuser(String userName, String password);

public boolean checkAdmin(String userName, String password);
}
  