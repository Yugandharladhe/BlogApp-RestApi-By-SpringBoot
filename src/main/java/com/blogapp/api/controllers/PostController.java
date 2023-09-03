package com.blogapp.api.controllers;
import com.blogapp.api.payloads.ApiResponse;

import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.api.payloads.PostDto;
import com.blogapp.api.services.PostServiceImpl;

@RestController
@RequestMapping("/api/post")
public class PostController {
	
	@Autowired
	PostServiceImpl postServiceImpl;
	
	@PostMapping("/create/{categoryId}/{userId}")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto PostDto,@PathVariable("categoryId") Integer categoryId,@PathVariable("userId") Integer userId)
	{
		PostDto postDto2=this.postServiceImpl.createPost(PostDto,userId,categoryId);
		return new ResponseEntity<PostDto>(postDto2,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllPost() {
		return ResponseEntity.ok(this.postServiceImpl.getAllPost());
	}
	
	@DeleteMapping("/delete/{postId}")
	public ApiResponse deletePost(@PathVariable("postId") Integer postId)
	{
		this.postServiceImpl.deletePost(postId);
		return new ApiResponse("user deleted Successfully",true);
	}
	
	@GetMapping("/get/{categoryId}")
	public ResponseEntity<?> getPostByCategory(@PathVariable("categoryId") Integer catId)
	{
		List<PostDto> posts=this.postServiceImpl.getPostByCategory(catId);
		return new ResponseEntity<>(posts,HttpStatus.FOUND);
	}
	
	@GetMapping("/getByUser/{userId}")
	public ResponseEntity<?> getPostByUser(@PathVariable("userId") Integer userId)
	{
		List<PostDto> posts=this.postServiceImpl.getPostByUser(userId);
		return new ResponseEntity<>(posts,HttpStatus.FOUND);
		
	}
	
	@PutMapping("/update/{postId}")
	public ResponseEntity<?> updatePost(@RequestBody PostDto postDto1,@PathVariable("postId") Integer postId)
	{
		PostDto postDto=this.postServiceImpl.updatePost(postDto1,postId);
		
		return new ResponseEntity<>(postDto,HttpStatus.OK);
		
	}
	
}
