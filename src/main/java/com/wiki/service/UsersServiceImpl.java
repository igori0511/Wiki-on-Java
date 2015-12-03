package com.wiki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wiki.model.Users;
import com.wiki.repository.UsersRepositoryService;


@Service("usersService")
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersRepositoryService usersRepository;

	@Transactional
	public Users save(Users user) {		
		user = crypt(user);
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		return usersRepository.save(user);
	}
	
	private Users crypt(Users user){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		return user;
	}
	
}
