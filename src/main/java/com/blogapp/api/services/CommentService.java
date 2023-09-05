package com.blogapp.api.services;


import com.blogapp.api.payloads.CommentDto;

public interface CommentService {
	public CommentDto createComment(CommentDto comment,Integer userId,Integer postId);
	public void deleteComment(Integer commentId);
}
