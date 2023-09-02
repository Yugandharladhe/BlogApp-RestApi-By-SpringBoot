package com.blogapp.api.payloads;

import java.util.Date;

import com.blogapp.api.entities.Category;
import com.blogapp.api.entities.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PostDto {
	
	private Integer postId;
	private String title;
	private String content;
	private String imageUrl;
	
	private Date addedDate;
	
	
	private CategoryDto category;
	
	
	private UserDto user;


	public Integer getPostId() {
		return postId;
	}


	public void setPostId(Integer postId) {
		this.postId = postId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public Date getAddedDate() {
		return addedDate;
	}


	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}


	public CategoryDto getCategory() {
		return category;
	}


	public void setCategory(CategoryDto category) {
		this.category = category;
	}


	public UserDto getUser() {
		return user;
	}


	public void setUser(UserDto user) {
		this.user = user;
	}


	public PostDto(Integer postId, String title, String content, String imageUrl, Date addedDate, CategoryDto category,
			UserDto user) {
		super();
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.imageUrl = imageUrl;
		this.addedDate = addedDate;
		this.category = category;
		this.user = user;
	}


	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
