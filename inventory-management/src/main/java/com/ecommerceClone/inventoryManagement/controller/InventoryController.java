package com.ecommerceClone.inventoryManagement.controller;

import com.ecommerceClone.inventoryManagement.entity.Inventory;
import com.ecommerceClone.inventoryManagement.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<Inventory> getAllItems() {
        return inventoryService.getAllItems();
    }

    @GetMapping("/{id}")
    public Inventory getItemsById(@PathVariable Long id) {
        return inventoryService.getItemsById(id);
    }

    @PostMapping
}
