package com.example.cruduniquecategoryback.service;

import com.example.cruduniquecategoryback.entity.Category;
import com.example.cruduniquecategoryback.record.CategoryDTO;
import com.example.cruduniquecategoryback.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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


  @Override
  public List<CategoryDTO> getAllCategories() {
    return this.categoryRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  @Override
  public Optional<CategoryDTO> getCategoryById(Long id) {
    return this.categoryRepository.findById(id).map(this::convertToDTO);
  }

  @Override
  public CategoryDTO createCategory(CategoryDTO categoryDTO) {
    Category category = convertToEntity(categoryDTO);
    Category savedCategory = categoryRepository.save(category);
    return convertToDTO(savedCategory);
  }

  @Override
  public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
    Category foundCategory = categoryRepository.findById(id).orElseThrow();
    foundCategory.setName(categoryDTO.name());
    Category updatedCategory = categoryRepository.save(foundCategory);
    return convertToDTO(updatedCategory);
  }

  @Override
  public CategoryDTO deleteCategory(Long id) {
    Category foundCategory = categoryRepository.findById(id).orElseThrow();
    categoryRepository.deleteById(id);
    return convertToDTO(foundCategory);
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
}
