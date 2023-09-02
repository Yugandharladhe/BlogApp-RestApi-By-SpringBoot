package com.blogapp.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.api.entities.Category;
import com.blogapp.api.entities.Post;
import com.blogapp.api.entities.User;

public interface PostRepository extends JpaRepository<Post,Integer>{
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category cat);
}
