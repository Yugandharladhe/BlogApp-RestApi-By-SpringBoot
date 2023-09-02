package com.blogapp.api.controllers;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.api.payloads.ApiResponse;
import com.blogapp.api.payloads.CategoryDto;
import com.blogapp.api.payloads.UserDto;
import com.blogapp.api.services.CategoryServiceImpl;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@PostMapping("/create")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto category)
	{
		CategoryDto catDto=this.categoryServiceImpl.createCategory(category);
		return new ResponseEntity<CategoryDto>(catDto,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto category,@PathVariable("catId") Integer catId)
	{
		CategoryDto catDto=this.categoryServiceImpl.updateCategory(category,catId);
		return ResponseEntity.ok(catDto);
	}
	
	@GetMapping("/getAllCategory")
	public ResponseEntity<ArrayList<CategoryDto>> getAllCategory()
	{
		ArrayList<CategoryDto> catDto=(ArrayList<CategoryDto>)this.categoryServiceImpl.getAllCategory();
		return ResponseEntity.ok(catDto);
	}
	
	@GetMapping("/getCategory/{catId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("catId") Integer catId)
	{
		CategoryDto catDto=this.categoryServiceImpl.getCategoryById(catId);
		return new ResponseEntity<CategoryDto>(catDto,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/delete/{catId}")
	public ResponseEntity<ApiResponse> deleteCategoryById(@PathVariable("catId") Integer catId)
	{
		this.categoryServiceImpl.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category deleted successfuly",false),HttpStatus.OK);
	}
	
}
