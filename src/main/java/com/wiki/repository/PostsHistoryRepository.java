package com.wiki.repository;

import java.util.List;

import com.wiki.model.Posts;
import com.wiki.model.PostsHistory;

public interface PostsHistoryRepository {

	public Posts save(Posts post);
	
	public List<PostsHistory> loadHistoryPost(String postUrl);
	
	public String getPostByIdUrl(Long postId, String postUrl);
}
