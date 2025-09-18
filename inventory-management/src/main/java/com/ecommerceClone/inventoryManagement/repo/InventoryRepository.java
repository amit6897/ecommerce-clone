package com.ecommerceClone.inventoryManagement.repo;

import com.ecommerceClone.inventoryManagement.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
