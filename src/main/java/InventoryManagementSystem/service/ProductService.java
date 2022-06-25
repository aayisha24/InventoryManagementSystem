package InventoryManagementSystem.service;

import java.util.List;

import InventoryManagementSystem.entity.Product;

public interface ProductService {

	Product saveProduct(Product product);

	List<Product> getProductList();

	Product getProductById(long id);

	Product updateProduct(long id, Product product);

	String deleteProduct(long id);

}
