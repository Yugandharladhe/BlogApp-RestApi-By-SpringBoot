package com.blogapp.api.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.api.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
