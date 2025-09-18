package com.ecommerceClone.inventoryManagement.service;

import com.ecommerceClone.inventoryManagement.entity.Inventory;
import com.ecommerceClone.inventoryManagement.repo.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getAllItems() {
        return inventoryRepository.findAll();
    }

    public Inventory getItemsById(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    public Inventory updateItem(Long id, Inventory inventory) {
        inventory.setId(id);
        return inventoryRepository.save(inventory);
    }

    public void deleteItem(Long id) {
        inventoryRepository.deleteById(id);
    }
}
