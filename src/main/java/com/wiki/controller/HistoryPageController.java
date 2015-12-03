package com.wiki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wiki.model.PostsHistory;
import com.wiki.service.PostsHistoryService;

@Controller
public class HistoryPageController {

	@Autowired
	private PostsHistoryService postsHistoryService;

	@RequestMapping(value = { "_history/{symbolicName:(?:[a-zA-Z0-9_-]+)*}",
			"{symbolicName:_history}" }, method = RequestMethod.GET)
	public String displayHistory(@PathVariable String symbolicName, Model model) {

		if (symbolicName.equals("_history")) {

			symbolicName = "_edit";
		}

		List<PostsHistory> historyPost = postsHistoryService.loadHistoryPost(symbolicName);
		
		if(symbolicName.equals("_edit")){
			symbolicName = null;
		}
		model.addAttribute("currentPost", historyPost);
		model.addAttribute("symbolicName", symbolicName);

		return "pageHistory";
	}

}