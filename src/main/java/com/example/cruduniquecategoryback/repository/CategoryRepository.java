package com.example.cruduniquecategoryback.repository;

import com.example.cruduniquecategoryback.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
