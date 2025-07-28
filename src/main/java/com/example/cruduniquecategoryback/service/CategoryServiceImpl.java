package com.example.cruduniquecategoryback.service;

import com.example.cruduniquecategoryback.entity.Category;
import com.example.cruduniquecategoryback.record.CategoryDTO;
import com.example.cruduniquecategoryback.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public CategoryServiceImpl(
      CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  private Category convertToEntity(CategoryDTO categoryDTO) {
    Category category = new Category();
    category.setId(categoryDTO.id());
    category.setName(categoryDTO.name());
    return category;
  }

  private CategoryDTO convertToDTO(Category category) {
    CategoryDTO categoryDTO = new CategoryDTO(category.getId(), category.getName());
    return categoryDTO;
  }

  @Override
  public CategoryDTO createCategory(CategoryDTO categoryDTO) {
    // System.out.println(categoryDTO.toString());
    Category category = convertToEntity(categoryDTO);
    Category savedCategory = categoryRepository.save(category);
    return convertToDTO(savedCategory);
  }
}
