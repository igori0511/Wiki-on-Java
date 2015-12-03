package com.wiki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wiki.model.Posts;
import com.wiki.service.PostsHistoryService;
import com.wiki.service.PostsService;

@Controller
public class EditPageController {
	/// _edit/**

	@Autowired
	private PostsService postsService;

	@Autowired
	private PostsHistoryService postsHistoryService;

	@RequestMapping(value = { "_edit/{symbolicName:(?:[a-zA-Z0-9_-]+)*}",
			"{symbolicName:_edit}" }, method = RequestMethod.GET)
	public String editPost(@PathVariable String symbolicName, Model model, @RequestParam(required = false) final String postId) {

		Posts post = new Posts();

		String pagedata = getPageData(symbolicName, postId);
		
		if (symbolicName.equals("_edit")) {
			symbolicName = "";
		}
		
		post.setPostData(pagedata);
		model.addAttribute("post", post);
		model.addAttribute("symbolicName", symbolicName);

		return "editPost";
	}

	@RequestMapping(value = { "_edit/{symbolicName:(?:[a-zA-Z0-9_-]+)*}",
			"{symbolicName:_edit}" }, method = RequestMethod.POST)
	public String updatePost(@PathVariable String symbolicName, @ModelAttribute("post") Posts post) {		
	
		post.setPostsUrl(symbolicName);

		postsService.save(post);
		postsHistoryService.save(post);

		if (symbolicName.equals("_edit")) {
			symbolicName = "";
		}

		return "redirect:/" + symbolicName;
	}
	
	private String getPageData(String symbolicName, String postId) {
		if (postId != null ) {
			return postsHistoryService.getPostByIdUrl(Long.parseLong(postId),symbolicName);

		} else {
			return postsService.getPageByPath(symbolicName);
		}
	}

}