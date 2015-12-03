package com.wiki.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wiki.model.Posts;
import com.wiki.model.PostsHistory;
import com.wiki.repository.PostsHistoryRepository;


@Service("postHistoryService")
public class PostsHistoryServiceImpl implements PostsHistoryService{
	

	@Autowired
	private PostsHistoryRepository postsHistoryInter;

	@Override
	@Transactional
	public Posts save(Posts post) {
		return postsHistoryInter.save(post);
	}

	@Override
	public List<PostsHistory> loadHistoryPost(String postUrl) {
		return postsHistoryInter.loadHistoryPost(postUrl);
	}

	@Override
	public String getPostByIdUrl(Long postId, String postUrl) {
		return postsHistoryInter.getPostByIdUrl(postId, postUrl);
	}

}
