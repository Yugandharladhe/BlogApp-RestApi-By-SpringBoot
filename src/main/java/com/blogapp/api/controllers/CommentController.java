package com.blogapp.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.blogapp.api.payloads.CommentDto;
import com.blogapp.api.services.CommentServiceImpl;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

	@Autowired
	CommentServiceImpl service;
	
	@PostMapping("/create/{postId}/{userId}")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment,@PathVariable("postId") Integer postId,@PathVariable("userId") Integer userId)
	{
		CommentDto created=this.service.createComment(comment, userId, postId);
		return new ResponseEntity<CommentDto>(created,HttpStatus.CREATED);
	}
}
