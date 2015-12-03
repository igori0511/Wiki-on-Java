package com.wiki.repository;

public class GetAllPostsPostData {

	private String postsUrl;

	private String postData;

	public GetAllPostsPostData(String postsUrl, String postData) {

		this.postsUrl = postsUrl;
		this.postData = postData;
	}

	public String getPostData() {
		return postData;
	}

	public String getPostsUrl() {
		return postsUrl;
	}

	public void setPostData(String postData) {
		this.postData = postData;
	}

	public void setPostsUrl(String postsUrl) {
		this.postsUrl = postsUrl;
	}
}
