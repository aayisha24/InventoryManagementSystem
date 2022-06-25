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
import InventoryManagementSystem.entity.Supplier;
import InventoryManagementSystem.service.CustomerService;
import InventoryManagementSystem.service.SupplierService;

@RestController
@RequestMapping("/api/customer")
public class SupplierController {
	@Autowired
	SupplierService supplierService;
	//RequestBody
	public SupplierController(SupplierService supplierService) {
		super();
		this.supplierService = supplierService;
		}
	//Supplier supplier = new Supplier("","")
	@PostMapping
	public ResponseEntity<Supplier> saveSupplier(@RequestBody Supplier supplier) {
		return new ResponseEntity<Supplier>(supplierService.saveSupplier(supplier),HttpStatus.CREATED);
		}
	
	@GetMapping
	public List<Supplier> getSupplierList() {
		return supplierService.getSupplierList();
	}
	//api/supplier/id	
	@GetMapping("/{id}")
	public Supplier getSupplierById(@PathVariable("id") long id) {
		return supplierService.getSupplierById(id);
	}
	@PutMapping("/{id}")
	public Supplier updateSupplier(@PathVariable("id") long id,@RequestBody Supplier supplier) {
		return supplierService.updateSupplier(id,supplier);
		}
	@DeleteMapping("/{id}")
	public ResponseEntity deleteSupplier(@PathVariable("id") long id) {
		return new ResponseEntity<String>(supplierService.deleteSupplier(id),HttpStatus.OK);
	}
	
}
