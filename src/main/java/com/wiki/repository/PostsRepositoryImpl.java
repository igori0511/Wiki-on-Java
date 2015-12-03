package com.wiki.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.wiki.model.Posts;

/**
 * @author Igor Zimenco
 *
 */
@Repository("postsRepository")
@SuppressWarnings({"rawtypes","unchecked"})
public class PostsRepositoryImpl implements PostsRepository {

	@PersistenceContext
	EntityManager em;
	
	/**
	 * Gets all posts from the Posts table
	 */
	
	public List<Posts> getAllPosts() {		
		return getAllPostsPrivate();	
	}	
	
	/**
	 * Saves a new post in the database
	 * Updates the post if the it exists in the database 
	 * @param post of type @Entity Posts
	 * @return post of type @Entity Posts
	 */
	public Posts save(Posts post) {

		List queryResult = getCompoundKey(post);
		
		if (queryResult.isEmpty()) {
			em.persist(post);
			em.flush();
		} else {
			Posts postFromDatabase = (Posts) em.find(Posts.class, queryResult.get(0));			
			postFromDatabase.setPostData(post.getPostData());			
		}

		return post;
	}
	
	/**
	 * Gets data for _edit page if data exists in database 
	 * @param postUrl of type String
	 * @return a String with post data if post exists in database otherwise empty String
	 *  
	 */
	public String getPageByPath(String postUrl) {

		List queryResult = checkEditPageDataExistance(postUrl);

		if (queryResult.isEmpty()) {
			return "";
		}

		return (String) queryResult.get(0);
	}

	/**
	 * Helper method for retrieving a compound key of type PostsCompoundKey
	 * @param post of type @Entity Posts
	 * @return a raw List if data exists, for input postUrl otherwise an empty List 
	 *  
	 */
	private List getCompoundKey(Posts post) {
		return em.createQuery("Select new com.wiki.model.PostsCompoundKey(p.postsId, p.postsUrl) from Posts p where p.postsUrl = ?1")
				.setParameter(1, post.getPostsUrl())
				.getResultList();
	}
	
	/**
	 * Helper method for retrieving post data for _edit page
	 * @param post of type @Entity Posts
	 * @return a raw List if data exists for input postUrl otherwise an empty List 
	 *  
	 */
	private List checkEditPageDataExistance(String postUrl) {
		return em.createQuery("Select postData from Posts p where p.postsUrl = ?1").setParameter(1, postUrl)
				.getResultList();
	}

	/**
	 * Helper method for retrieving all posts from database  
	 */
	private List getAllPostsPrivate() {
		return em.createQuery("Select new com.wiki.repository.GetAllPostsPostData(postsUrl,postData) from Posts p ").getResultList();
	}

}