package com.wiki.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "POSTS")
@IdClass(PostsCompoundKey.class)
public class Posts {

	@Id
	@GeneratedValue
	@Column(name = "POST_ID")
	private Long postsId;
	
	@Id
	@Column(name = "POST_URL")	
	private String postsUrl;

	@Column(name = "POST_DATA",length=4000)
	private String postData;

	@OneToMany(mappedBy="posts",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<PostsHistory> postsHistory = new ArrayList<PostsHistory>();

	public Long getPostsId() {
		return postsId;
	}

	public void setPostsId(Long postsId) {
		this.postsId = postsId;
	}

	public String getPostsUrl() {
		return postsUrl;
	}

	public void setPostsUrl(String postsUrl) {
		this.postsUrl = postsUrl;
	}

	public String getPostData() {
		return postData;
	}

	public void setPostData(String postData) {
		this.postData = postData;
	}

	public List<PostsHistory> getPostsHistory() {
		return postsHistory;
	}

	public void setPostsHistory(List<PostsHistory> postsHistory) {
		this.postsHistory = postsHistory;
	}
}