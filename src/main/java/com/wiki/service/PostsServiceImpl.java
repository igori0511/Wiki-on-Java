package com.wiki.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wiki.model.Posts;
import com.wiki.repository.PostsRepository;

@Service("postsService")
public class PostsServiceImpl implements PostsService{
	
	@Autowired
	private PostsRepository postsRepository;

	@Override
	@Transactional
	public Posts save(Posts post) {
		return postsRepository.save(post);
	}

	@Override
	public String getPageByPath(String postUrl) {
		return postsRepository.getPageByPath(postUrl);
	}

	@Override
	public List<Posts> getAllPosts() {
		return postsRepository.getAllPosts();
	}
}
