package com.wiki.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.wiki.model.Posts;
import com.wiki.model.PostsHistory;

@SuppressWarnings("rawtypes")
@Repository("postsHistoryRepository")
public class PostsHistoryRepositoryImpl implements PostsHistoryRepository{
	
	@PersistenceContext
	EntityManager em;
	
	/**
	 * Saves post history to the database
	 * Updates the post history if the it exists in the database 
	 * @param post of type @Entity Posts
	 * @return post of type @Entity Posts
	 */
	public Posts save(Posts post) {
		
		boolean equalsOrExists = false;

		List queryResult = getCompoundKey(post);

		Posts postFromDatabase = (Posts) em.find(Posts.class, queryResult.get(0));
		List<PostsHistory> postsHistory = postFromDatabase.getPostsHistory();

		if (postsHistory.isEmpty()) {
			createPostsHistory(post, postFromDatabase);
			equalsOrExists = true;
		}else{
			for (PostsHistory postsHistElem : postsHistory) {
				if (postsHistElem.getPostData().equals(post.getPostData())) {
					equalsOrExists = true;
					break;
				}
			}
		}
		
		if(!equalsOrExists){
			createPostsHistory(post, postFromDatabase);
		}

		return post;
	}
	
	/**
	 * Gets all the posts for a given input post
	 * @param post of type @Entity Posts
	 * @return a raw List of @Entiry Posts associated with post
	 *  
	 */
	public List<PostsHistory> loadHistoryPost(String postUrl){		

		List queryResult = getCompoundKey(postUrl);
		Posts postFromDatabase = null;
		List<PostsHistory> postsHistory = null;
		
		if(!queryResult.isEmpty()){
			postFromDatabase = (Posts)em.find(Posts.class, queryResult.get(0));
			postsHistory = postFromDatabase.getPostsHistory();
		}			
		
		return postsHistory;
	}
	
	/**
	 * Gets a post by postId
	 * @param postId if type Long
	 * @return postData
	 *  
	 */	
	public String getPostByIdUrl(Long postId, String postUrl) {

		List queryResult = getPost(postId,postUrl);

		return (String) queryResult.get(0);
	}
	
	/**
	 * Helper method for retrieving postData from PostsHistory by post id
	 * @param postId if type Long
	 * @return postData
	 *  
	 */	
	private List getPost(Long postId, String postUrl) {
		return em.createQuery("Select postData from PostsHistory p where p.historyId = ?1 and p.posts.postsUrl = ?2")
				.setParameter(1, postId).setParameter(2, postUrl)
				.getResultList();
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
	 * Helper method for retrieving a compound key of type PostsCompoundKey
	 * @param postUrl of type String 
	 * @return a raw List if data exists, for input postUrl otherwise an empty List 
	 *  
	 */
	private List getCompoundKey(String postUrl) {
		return em.createQuery("Select new com.wiki.model.PostsCompoundKey(p.postsId, p.postsUrl) from Posts p where p.postsUrl = ?1")
				.setParameter(1, postUrl)
				.getResultList();
	}	
	
	/**
	 * Helper method for creating post history
	 * @param post of type @Entity Posts
	 * @param post of type @Entity Posts
	 * @return a raw List if data exists, for input postUrl otherwise an empty List 
	 *  
	 */
	private void createPostsHistory(Posts post, Posts postFromDatabase) {
		PostsHistory newHist = new PostsHistory();
		newHist.setPostData(post.getPostData());
		newHist.setPosts(postFromDatabase);
		em.persist(newHist);
	}	

}