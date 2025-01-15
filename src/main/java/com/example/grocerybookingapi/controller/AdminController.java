package com.example.grocerybookingapi.controller;

import com.example.grocerybookingapi.model.GroceryItem;
import com.example.grocerybookingapi.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private GroceryService service;

    @PostMapping("/add")
    public ResponseEntity<GroceryItem> addItem(@RequestBody GroceryItem item) {
        return ResponseEntity.ok(service.addGroceryItem(item));
    }

    @GetMapping("/items")
    public ResponseEntity<List<GroceryItem>> getAllItems() {
        return ResponseEntity.ok(service.getAllItems());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        service.deleteGroceryItem(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GroceryItem> updateItem(@PathVariable Long id, @RequestBody GroceryItem item) {
        return ResponseEntity.ok(service.updateGroceryItem(id, item));
    }
}
