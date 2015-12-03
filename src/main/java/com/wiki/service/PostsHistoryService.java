package com.wiki.service;

import java.util.List;

import com.wiki.model.Posts;
import com.wiki.model.PostsHistory;

public interface PostsHistoryService {

	public List<PostsHistory> loadHistoryPost(String postUrl);

	public Posts save(Posts post);
	
	public String getPostByIdUrl(Long postId, String postUrl);
}