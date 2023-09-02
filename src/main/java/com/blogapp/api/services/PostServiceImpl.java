package com.blogapp.api.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.api.entities.Category;
import com.blogapp.api.entities.User;
import com.blogapp.api.exceptions.ResourceNotFoundException;
import com.blogapp.api.entities.Post;
import com.blogapp.api.payloads.PostDto;
import com.blogapp.api.repositories.CategoryRepository;
import com.blogapp.api.repositories.PostRepository;
import com.blogapp.api.repositories.UserRepository;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	PostRepository postRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public PostDto create(PostDto postDto,Integer userId,Integer categoryId) {
		// TODO Auto-generated method stub
		Post post=this.modelMapper.map(postDto, Post.class);
		post.setImageUrl("default.png");
		post.setAddedDate(new Date());
		Category category=this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","id",categoryId));
		User user=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		post.setCategory(category);
		post.setUser(user);
		
		Post req=this.modelMapper.map(postDto, Post.class);
		post.setTitle(req.getTitle());
		post.setContent(req.getContent());
		Post saved=this.postRepository.save(post);
		return this.modelMapper.map(saved,PostDto.class);	
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub
		Post post=this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","id",postId));
		System.out.print(post);
		this.postRepository.delete(post);
	}

	@Override
	public List<PostDto> getAllPost() {
		// TODO Auto-generated method stub
		List<Post> posts=this.postRepository.findAll();
		List<PostDto> res=new ArrayList<>();
		posts.forEach((post)->{
			res.add(this.modelMapper.map(post, PostDto.class));
		});
		
		return res;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		// TODO Auto-generated method stub
		Post post=this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","id",postId));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat=this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","id",categoryId));
		List<Post> posts=this.postRepository.findByCategory(cat);
		List<PostDto> res=new ArrayList<>();
		posts.forEach((post)->{
			res.add(this.modelMapper.map(post, PostDto.class));
		});
		return res;
	}

	@Override
	public List<Post> getPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post create(PostDto postDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
