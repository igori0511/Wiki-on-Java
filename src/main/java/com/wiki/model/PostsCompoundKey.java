package com.wiki.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PostsCompoundKey implements Serializable{

	private Long postsId;
	
	private String postsUrl;

	public PostsCompoundKey(){}
	
	public PostsCompoundKey(Long userId, String postsUrl){
		this.postsId = userId;
		this.postsUrl = postsUrl;
	}	
	
	public Long getUserId() {
		return postsId;
	}

	public String getNickNames() {
		return postsUrl;
	}
	
	public boolean equals(Object other) {
	    if (this == other)
	        return true;
	    if (!(other instanceof PostsCompoundKey))
	        return false;
	    PostsCompoundKey castOther = (PostsCompoundKey) other;
	    return postsId.equals(castOther.postsId) && postsUrl.equals(castOther.postsUrl);
	}

	public int hashCode() {
	    final int prime = 31;
	    int hash = 17;
	    hash = hash * prime + this.postsId.hashCode();
	    hash = hash * prime + this.postsUrl.hashCode();
	    return hash;
	}	
}