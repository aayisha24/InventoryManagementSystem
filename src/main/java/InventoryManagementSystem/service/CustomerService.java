package InventoryManagementSystem.service;

import java.util.List;

import InventoryManagementSystem.entity.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);

	List<Customer> getCustomerList();

	Customer getCustomerById(long id);

	Customer updateCustomer(long id, Customer customer);

	String deleteCustomer(long id);

	List<Customer> getCustomerByFirstName(String firstName);

	List<Customer> getCustomerByLastName(String lastName);

	List<Customer> getCustomerByFullName(String firstName, String lastName);

}
