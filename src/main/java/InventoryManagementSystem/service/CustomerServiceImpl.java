package InventoryManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import InventoryManagementSystem.entity.Customer;
import InventoryManagementSystem.exception.ResourceNotFoundException;
import InventoryManagementSystem.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	CustomerRepository customerrepository;
	public CustomerServiceImpl(CustomerRepository customerrepository) {
		super();
		this.customerrepository = customerrepository;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerrepository.save(customer);
	}

	@Override
	public List<Customer> getCustomerList() {
		// TODO Auto-generated method stub
		return customerrepository.findAll();
	}

	@Override
	public Customer getCustomerById(long id) {
		//throw            throws
		Customer customer=new Customer();
		customer = customerrepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Customer","id",id));
		return customer;
	}

	@Override
	public Customer updateCustomer(long id, Customer customer) {
		Customer cust=new Customer();
		cust = customerrepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Customer","id",id));
		
		cust.setFirstName(customer.getFirstName());
		cust.setLastName(customer.getLastName());
		cust.setEmail(customer.getEmail());
		cust.setContactNo(customer.getContactNo());
		cust.setAddress(customer.getAddress());
		customerrepository.save(cust);
		return cust;
	}

	@Override
	public String deleteCustomer(long id) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer = customerrepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Customer","id",id));
		customerrepository.deleteById(id);
		return "Record is deleted successfully";
		
	}

	@Override
	public List<Customer> getCustomerByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return customerrepository.getCustomerByFirstName(firstName);
	}

	@Override
	public List<Customer> getCustomerByLastName(String lastName) {
		// TODO Auto-generated method stub
		return customerrepository.getCustomerByLastName(lastName);
	}

	@Override
	public List<Customer> getCustomerByFullName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return customerrepository.getCustomerByFullName(firstName,lastName) ;
	}
	

}
