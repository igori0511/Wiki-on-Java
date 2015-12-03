package com.wiki.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "POSTS_HISTORY")
public class PostsHistory {

	@Id
	@GeneratedValue
	@Column(name = "POST_HISTORY_ID")
	private Long historyId;

	@Column(name = "POST_DATA",length=4000)
	private String postData;

	@ManyToOne
	private Posts posts;

	public Long getHistoryId() {
		return historyId;
	}

	public String getPostData() {
		return postData;
	}

	public Posts getPosts() {
		return posts;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	public void setPostData(String postData) {
		this.postData = postData;
	}

	public void setPosts(Posts posts) {
		this.posts = posts;
	}

}