package InventoryManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import InventoryManagementSystem.entity.Customer;
import InventoryManagementSystem.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	//RequestBody
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
		}
	//Customer customer = new Customer("","")
	@PostMapping
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.saveCustomer(customer),HttpStatus.CREATED);
		}
	
	@GetMapping
	public List<Customer> getCustomerList() {
		return customerService.getCustomerList();
	}
	//api/customer/id	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable("id") long id) {
		return customerService.getCustomerById(id);
	}
	@PutMapping("/{id}")
	public Customer updateCustomer(@PathVariable("id") long id,@RequestBody Customer customer) {
		return customerService.updateCustomer(id,customer);
		}
	@DeleteMapping("/{id}")
	public ResponseEntity deleteCustomer(@PathVariable("id") long id) {
		return new ResponseEntity<String>(customerService.deleteCustomer(id),HttpStatus.OK);
	}
	@GetMapping("/GetByFirstName/{firstName}")
	public List<Customer> getCustomerByFirstName(@PathVariable("firstName") String firstName) {
		return customerService.getCustomerByFirstName(firstName);
	}
	@GetMapping("/GetByLastName/{lastName}")
	public List<Customer> getCustomerByLastName(@PathVariable("lastName") String lastName) {
		return customerService.getCustomerByLastName(lastName);
	}
	@GetMapping("/GetCustomerByFullName/{firstName}/{lastName}")
	public List<Customer> getCustomerByFullName(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName) {
		return customerService.getCustomerByFullName(firstName,lastName);
	}
} 

