package com.blogapp.api.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.api.entities.*;
import com.blogapp.api.entities.Comment;
import com.blogapp.api.entities.Post;
import com.blogapp.api.exceptions.ResourceNotFoundException;
import com.blogapp.api.payloads.CommentDto;
import com.blogapp.api.repositories.CommentRepository;
import com.blogapp.api.repositories.PostRepository;
import com.blogapp.api.repositories.UserRepository;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentRepository commentRepo;
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer userId, Integer postId) {
		// TODO Auto-generated method stub
		Comment comm=this.modelMapper.map(commentDto,Comment.class);
		Post post=this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","id",postId));
		User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		comm.setPost(post);
		comm.setUser(user);
		this.commentRepo.save(comm);
		return this.modelMapper.map(comm, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		// TODO Auto-generated method stub
		
	}

}
