package com.example.cruduniquecategoryback.controller;

import com.example.cruduniquecategoryback.record.CategoryDTO;
import com.example.cruduniquecategoryback.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/categories")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  public CategoryController(
      CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping
  public List<CategoryDTO> getAllCategories() {
    return categoryService.getAllCategories();
  }

  @GetMapping("/{id}")
  public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
    return categoryService.getCategoryById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
    return categoryService.createCategory(categoryDTO);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
    try {
      CategoryDTO updatedCategory = categoryService.updateCategory(id, categoryDTO);
      return ResponseEntity.ok(updatedCategory);
    } catch (Exception e) {
      System.err.println("Error: " + e);
      return ResponseEntity.notFound().build();
    }

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long id) {
    try {
      CategoryDTO deletedCategory = categoryService.deleteCategory(id);
      return ResponseEntity.ok(deletedCategory);
    } catch (Exception e) {
      System.err.println("Error: " + e);
      return ResponseEntity.notFound().build();
    }
  }

}
