package com.wiki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wiki.model.Posts;
import com.wiki.service.PostsService;

@Controller
public class AllPostsController {

	@Autowired
	private PostsService postsService;
	
	@RequestMapping(value = { "getallposts" }, method = RequestMethod.GET)
	public String allPosts(Model model) {
		
		List<Posts> allPosts = postsService.getAllPosts();
		
		model.addAttribute("allposts",allPosts);
		
		return "getAllPosts";
	}	
}