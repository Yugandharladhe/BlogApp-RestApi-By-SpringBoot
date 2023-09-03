package com.blogapp.api.payloads;

import java.util.ArrayList;
import java.util.List;

import com.blogapp.api.entities.Comment;
import com.blogapp.api.entities.Post;
import com.blogapp.api.entities.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CommentDto {

	private int id;
	private String comment;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
