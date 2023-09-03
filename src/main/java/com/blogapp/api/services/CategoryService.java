package com.blogapp.api.services;

import java.util.List;

import com.blogapp.api.payloads.CategoryDto;


public interface CategoryService {
	public CategoryDto createCategory(CategoryDto categoryDto);
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	public CategoryDto getCategoryById(Integer categoryId);
	public List<CategoryDto> getAllCategory();
	public void deleteCategory(Integer categoryId);
}
