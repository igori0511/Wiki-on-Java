package com.wiki.service;

import java.util.List;

import com.wiki.model.Posts;

public interface PostsService {

	public Posts save(Posts post);
	
	public List<Posts> getAllPosts();
	
	public String getPageByPath(String postUrl);
}
