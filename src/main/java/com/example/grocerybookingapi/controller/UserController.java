package com.example.grocerybookingapi.controller;

import com.example.grocerybookingapi.model.GroceryItem;
import com.example.grocerybookingapi.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private GroceryService service;

    @GetMapping("/items")
    public ResponseEntity<List<GroceryItem>> getAllItems() {
        return ResponseEntity.ok(service.getAllItems());
    }

    @PostMapping("/book")
    public ResponseEntity<String> bookItems(@RequestBody List<Long> itemIds) {
        return ResponseEntity.ok("Items booked successfully!");
    }
}
