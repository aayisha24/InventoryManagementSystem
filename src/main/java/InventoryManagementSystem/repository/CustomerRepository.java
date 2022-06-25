package InventoryManagementSystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import InventoryManagementSystem.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	@Query("select c from customerTbl c where e.firstName= :firstName")
	List<Customer> getCustomerByFirstName(@Param("firstName")String firstName);
	
	@Query("select c from customerTblc where c.firstName= :firstName and c.lastName= :lastName")
	List<Customer> getCustomerByFullName(@Param("firstName")String firstName,@Param("lastName")String lastName);
	
	List<Customer> findByLastName(String lastName);
	
	Optional<Customer>findByEmail(String string);

	List<Customer> getCustomerByLastName(String lastName);
	

}
