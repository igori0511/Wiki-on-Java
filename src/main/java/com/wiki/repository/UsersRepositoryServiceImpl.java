package com.wiki.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.wiki.model.Users;

@Repository("usersRepository")
public class UsersRepositoryServiceImpl implements UsersRepositoryService{	
	
	@PersistenceContext
	EntityManager em;	
	
	public Users save(Users user){
		em.persist(user);
		em.flush();
		return user;
	}	

}