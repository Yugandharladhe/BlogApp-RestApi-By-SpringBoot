package com.blogapp.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.api.entities.Category;
import com.blogapp.api.exceptions.ResourceNotFoundException;
import com.blogapp.api.payloads.CategoryDto;
import com.blogapp.api.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		Category category=this.dtoToCategory(categoryDto);
		category=this.categoryRepository.save(category);
		return this.categoryToDto(category);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		// TODO Auto-generated method stub
		Category category=this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","id",categoryId));
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category=this.categoryRepository.save(category);
		return this.categoryToDto(category);
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		// TODO Auto-generated method stub
		Category category=this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","id",categoryId));
		return this.categoryToDto(category);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		// TODO Auto-generated method stub
		List<CategoryDto> catDto=new ArrayList<>();
		List<Category> category=this.categoryRepository.findAll();
		category.forEach((cat)->{
			catDto.add(this.modelMapper.map(cat, CategoryDto.class));
		});
		return catDto;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category category=this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","id",categoryId));
		this.categoryRepository.delete(category);
	}
	
	public CategoryDto categoryToDto(Category category)
	{
		return modelMapper.map(category, CategoryDto.class);
	}
	
	public Category dtoToCategory(CategoryDto categoryDto)
	{
		return modelMapper.map(categoryDto, Category.class);
	}



}
