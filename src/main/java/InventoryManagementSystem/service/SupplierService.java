package InventoryManagementSystem.service;

import java.util.List;

import InventoryManagementSystem.entity.Supplier;

public interface SupplierService {

	Supplier saveSupplier(Supplier supplier);

	List<Supplier> getSupplierList();

	Supplier getSupplierById(long id);

	Supplier updateSupplier(long id, Supplier supplier);

	String deleteSupplier(long id);

}
