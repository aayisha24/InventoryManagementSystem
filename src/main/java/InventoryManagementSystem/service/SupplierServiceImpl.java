package InventoryManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import InventoryManagementSystem.entity.Customer;
import InventoryManagementSystem.entity.Supplier;
import InventoryManagementSystem.exception.ResourceNotFoundException;
import InventoryManagementSystem.repository.CustomerRepository;
import InventoryManagementSystem.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {
	SupplierRepository supplierrepository;
	private Supplier supplier;
	public SupplierServiceImpl(SupplierRepository supplierrepository) {
		super();
		this.supplierrepository = supplierrepository;
	}

	@Override
	public Supplier saveSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierrepository.save(supplier) ;
	}

	@Override
	public List<Supplier> getSupplierList() {
		// TODO Auto-generated method stub
		return supplierrepository.findAll();
	}

	@Override
	public Supplier getSupplierById(long id) {
		 //throw            throws
		Supplier customer=new Supplier();
		supplier = supplierrepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Supplier","id",id));
		return supplier;
		
	}

	@Override
	public Supplier updateSupplier(long id, Supplier supplier) {
		Supplier sup=new Supplier();
		sup = supplierrepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Supplier","id",id));
		
		sup.setName(supplier.getName());
		sup.setEmail(supplier.getEmail());
		sup.setContactNo(supplier.getContactNo());
		sup.setAddress(supplier.getAddress());
		supplierrepository.save(sup);
		return sup;
	
	}

	@Override
	public String deleteSupplier(long id) {
		Supplier supplier = new Supplier();
		supplier = supplierrepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Supplier","id",id));
		supplierrepository.deleteById(id);
		return "Record is deleted successfully";
		
	}
	}


