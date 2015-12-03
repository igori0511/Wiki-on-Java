package com.wiki.repository;

import java.util.List;

import com.wiki.model.Posts;

public interface PostsRepository {

	public Posts save(Posts post);
	
	public List<Posts> getAllPosts();
	
	public String getPageByPath(String postUrl);
	
}
