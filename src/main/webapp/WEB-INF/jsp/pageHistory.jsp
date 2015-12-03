<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<t:wrapper> 
<title>History</title>
</t:wrapper>
<body>	 	

	<c:set var="start"  scope="session" value='0'/>
	<c:set var="end" scope="session" value='250'/>
	
	<c:set var="historyActive" scope="session" value='active'/>
	
	<t:navbarVars/>
	
	<t:navbar/>		
	
	<c:set var="slash" scope="session" value="/"/>
 	<c:set var="headerValue" scope="session" value="${symbolicName}"/> 
	
	<c:if test="${symbolicName == null}">
		<c:set var="slash" scope="session" value=""/>
		<c:set var="headerValue" scope="session" value="Main"/>	 
	</c:if> 
	
	<div class="container">
		<h1>CURRENT POSTS FOR:<c:out value="${headerValue}"/></h1>
	
		<c:forEach items="${currentPost}" var="post">
			<div class="background">
				<div class="center">
					<div class="post-data">
						 ${fn:substring(post.postData, start, end)}
					</div>
						
		 			<div class="edit-link">
		 				<a  class="btn btn-default" href = "/Wiki/_edit/${symbolicName}<c:out value="${slash}"/>?postId=${post.historyId}">Edit post</a>
		 			</div>
		 			
		 			<div class="view-link">
						<a class="btn btn-success" href = "/Wiki/${symbolicName}<c:out value="${slash}"/>?postId=${post.historyId}">View post</a>
					</div>
				</div>
			</div>
	
		</c:forEach>
	</div>	
</body>
</html>