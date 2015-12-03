<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<t:wrapper> 
<title>Get All Posts</title>
</t:wrapper>
<body>

	<c:set var="start"  scope="session" value='0'/>
	<c:set var="end" scope="session" value='250'/>
	
	<c:set var="allPostsActive" scope="session" value='active'/>

	<c:set var="link"  scope="session" value=''/>
	<c:set var="link2" scope="session" value=''/>
	<c:set var="link3" scope="session" value='<li class="${allPostsActive}"><a href = "/Wiki/getallposts">AllPosts</a></li>'/>
	<c:set var="link4" scope="session" value=''/>
	<c:set var="link5" scope="session" value='<li><a href = "/Wiki/logout">Logout</a></li>'/>
	
	<c:set var="links" scope="session" >${link},${link2},${link3},${link4}</c:set>
	<c:set var="linksRight" scope="session" >${link5},</c:set>
	
	<t:navbar/>			
	
	<div class='container'>
		<h1>All Posts</h1>
		
			<c:forEach items="${allposts}" var="post">
			
				<c:set var="postUrl" scope="session" value="${post.postsUrl}"/>
				
				<c:if test="${postUrl == '_edit'}">
					<c:set var="postUrl" scope="session" value=""/>
				</c:if> 				
					<div class="background">
						<div class="center">
							<div class="post-data">
								${fn:substring(post.postData, start, end)}
							</div>	
							
							<div class="edit-link">					
								<a class="btn btn-default" href = "/Wiki/_edit/<c:out value="${postUrl}"/>">Edit Post</a>
							</div>
							
							<div class="view-link">
								<a class="btn btn-success" href = "/Wiki/<c:out value="${postUrl}"/>">View Post</a>
							</div>
						</div>
					</div>						
			</c:forEach>
	</div>
	
</body>
</html>