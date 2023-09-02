package com.blogapp.api.services;

import java.util.List;

import com.blogapp.api.payloads.UserDto;

public interface UserService {
	public UserDto createUser(UserDto user);
	public UserDto updateUser(UserDto user,Integer id);
	public UserDto getUserById(Integer userId);
	public List<UserDto> getAllUsers();
	public void deleteUser(Integer userId);
}
