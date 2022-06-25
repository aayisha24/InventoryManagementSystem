package InventoryManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import InventoryManagementSystem.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier ,Long> {

}
