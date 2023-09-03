package com.blogapp.api.services;


import java.util.List;


import com.blogapp.api.entities.Post;

import com.blogapp.api.payloads.PostDto;


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
