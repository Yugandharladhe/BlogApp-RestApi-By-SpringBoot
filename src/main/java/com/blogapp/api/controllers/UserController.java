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
import com.blogapp.api.payloads.UserDto;
import com.blogapp.api.services.UserServiceImpl;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	//POST-create user
	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
	{
		UserDto createdUser=this.userServiceImpl.createUser(userDto);
		return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
	}
	
	//PUT-update user
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer userId)
	{
		UserDto updatedUser=this.userServiceImpl.updateUser(userDto, userId);
		return ResponseEntity.ok(updatedUser);
		
	}
	
	//DELETE -delete user
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId)
	{
		this.userServiceImpl.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully",true),HttpStatus.OK);
	}
	//GET-user get
	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Integer userId)
	{
		UserDto userDto=this.userServiceImpl.getUserById(userId);
		return new ResponseEntity<UserDto>(userDto,HttpStatus.FOUND);
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<ArrayList<UserDto>> getAllUser()
	{
		ArrayList<UserDto> userDtos=(ArrayList<UserDto>) this.userServiceImpl.getAllUsers();
		return ResponseEntity.ok(userDtos);
	}
}
