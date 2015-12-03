package com.wiki.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Users {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "ENABLED")
	private boolean enabled;

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public Long getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
