package com.example.grocerybookingapi.service;

import com.example.grocerybookingapi.model.GroceryItem;
import com.example.grocerybookingapi.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryService {

    @Autowired
    private GroceryItemRepository repository;

    public GroceryItem addGroceryItem(GroceryItem item) {
        return repository.save(item);
    }

    public List<GroceryItem> getAllItems() {
        return repository.findAll();
    }

    public void deleteGroceryItem(Long id) {
        repository.deleteById(id);
    }

    public GroceryItem updateGroceryItem(Long id, GroceryItem updatedItem) {
        return repository.findById(id).map(item -> {
            item.setName(updatedItem.getName());
            item.setPrice(updatedItem.getPrice());
            item.setQuantity(updatedItem.getQuantity());
            return repository.save(item);
        }).orElseThrow(() -> new RuntimeException("Item not found"));
    }
}
