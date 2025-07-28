package com.example.cruduniquecategoryback.service;

import com.example.cruduniquecategoryback.record.CategoryDTO;
import java.util.List;
import java.util.Optional;

public interface CategoryService {

  List<CategoryDTO> getAllCategories();

  Optional<CategoryDTO> getCategoryById(Long id);

  CategoryDTO createCategory(CategoryDTO categoryDTO);

}
