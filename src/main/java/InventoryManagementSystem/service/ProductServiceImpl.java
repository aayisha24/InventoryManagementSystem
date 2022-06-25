package InventoryManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import InventoryManagementSystem.entity.Customer;
import InventoryManagementSystem.entity.Product;
import InventoryManagementSystem.exception.ResourceNotFoundException;
import InventoryManagementSystem.repository.CustomerRepository;
import InventoryManagementSystem.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	ProductRepository productrepository;
	public ProductServiceImpl(ProductRepository productrepository) {
		super();
		this.productrepository = productrepository;
	}
	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productrepository.save(product);
	}

	@Override
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return productrepository.findAll();
	}

	@Override
	public Product getProductById(long id) {
		 //throw            throws
		Product product=new Product();
		product = productrepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Product","id",id));
		return product;
	}

	@Override
	public Product updateProduct(long id, Product product) {
	
		Product prod=new Product();
		prod = productrepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Product","id",id));
		
		prod.setName(product.getName());
		prod.setPrice(product.getPrice());
		prod.setQuantity(product.getQuantity());
		productrepository.save(product);
		return product;
		
	}

	@Override
	public String deleteProduct(long id) {
		Product product = new Product();
		product = productrepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Product","id",id));
		productrepository.deleteById(id);
		return "Record is deleted successfully";
		
		
	}

}
