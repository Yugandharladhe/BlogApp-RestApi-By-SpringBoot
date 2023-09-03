package com.blogapp.api.services;

import java.util.Date;
import java.util.List;

import com.blogapp.api.entities.Category;
import com.blogapp.api.entities.Post;
import com.blogapp.api.entities.User;
import com.blogapp.api.payloads.PostDto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public interface PostService {
	
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	public void deletePost(Integer postId);
	
	public PostDto updatePost(PostDto postDto,Integer postId);
	
	public List<PostDto> getAllPost();
	
	public PostDto getPostById(Integer postId);
	
	public List<PostDto> getPostByCategory(Integer categoryId);
	
	public List<PostDto> getPostByUser(Integer userId);
	
	//search post
	
	public List<Post> searchPost(String keyword);
}
