package com.blogapp.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.api.entities.User;
import com.blogapp.api.exceptions.ResourceNotFoundException;
import com.blogapp.api.payloads.UserDto;
import com.blogapp.api.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user=this.dtoToUser(userDto);
		user=this.userRepository.save(user);
		UserDto dto=this.userToDto(user);
		return dto;
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer id) {
		
		User user=this.userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id",id));
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updatedUser=this.userRepository.save(user);
		UserDto userDto2=this.userToDto(updatedUser);
		return userDto2;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		
		User user=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		
		return this.userToDto(user);
	
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users=this.userRepository.findAll();
		List<UserDto> userDtos = new ArrayList<>();
		users.forEach(user->{
			userDtos.add(this.userToDto(user));
		});
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		
		User user=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		this.userRepository.delete(user);
	}
	
	public UserDto userToDto(User user)
	{
		
		UserDto userDto=this.modelMapper.map(user, UserDto.class);
//		UserDto userDto=new UserDto();
//		userDto.setId(user.getId());
//		userDto.setEmail(user.getEmail());
//		userDto.setName(user.getName());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		
		return userDto;
	}
	
	public User dtoToUser(UserDto userDto)
	{
		User user=this.modelMapper.map(userDto, User.class);
		
//		User user=new User();
//		user.setId(userDto.getId());
//		user.setEmail(userDto.getEmail());
//		user.setName(userDto.getName());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		
		return user;
	}

}
