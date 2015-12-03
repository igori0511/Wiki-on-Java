package com.wiki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wiki.service.PostsHistoryService;
import com.wiki.service.PostsService;

@Controller
public class MainPageController {

	@Autowired
	private PostsService postsService;
	
	@Autowired
	private PostsHistoryService postsHistoryService;

	@RequestMapping(value = { "/{symbolicName:(?:[a-zA-Z0-9_-]+)*}" , 
							  "/{symbolicName:^(?!login)", 
							  "/{symbolicName:^(?!logout)",
							  "/{symbolicName:^(?!getallposts)"}, method = RequestMethod.GET)
	public String displayMain(@PathVariable String symbolicName, Model model, @RequestParam(required = false) final String postId) {
		
		String pagedata = getPageData(symbolicName,postId);	
		
		if(postId != null){
			model.addAttribute("symbolicNameEdit", symbolicName+"/?postId="+postId);
		}else{
			model.addAttribute("symbolicNameEdit", symbolicName);
		}

		model.addAttribute("currentPost", pagedata);
		model.addAttribute("symbolicName", symbolicName);

		return redirectLogic(symbolicName, pagedata);

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayMain(Model model, @RequestParam(required = false) final String postId) {

		String pagedata = getPageData("_edit",postId);

		model.addAttribute("currentPost", pagedata);
		
		if(postId != null){
			model.addAttribute("symbolicNameEdit", "?postId="+postId);
		}
		
		model.addAttribute("symbolicName", "");		

		return redirectLogic("_edit", pagedata);
	}

	private String redirectLogic(String symbolicName, String pagedata) {

		if (symbolicName.equals("_edit")) {
			symbolicName = "";
		}

	    if (pagedata.isEmpty()) {
			return "redirect:/_edit/" + symbolicName;
		}
		
		return "displayMainPage";

	}
	
	private String getPageData(String symbolicName, String postId) {
		if (postId != null ) {
			return postsHistoryService.getPostByIdUrl(Long.parseLong(postId),symbolicName);

		} else {
			return postsService.getPageByPath(symbolicName);
		}
	}
	
}