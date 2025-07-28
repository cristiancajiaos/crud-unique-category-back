package com.example.cruduniquecategoryback.service;

import com.example.cruduniquecategoryback.record.CategoryDTO;
import java.util.List;

public interface CategoryService {

  List<CategoryDTO> getAllCategories();

  CategoryDTO createCategory(CategoryDTO categoryDTO);

}
