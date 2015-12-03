<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html">
<html>
<t:wrapper> 
<title>Login Page</title>
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
	
	
	<div class="container">
		
			<%-- ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} --%>
			
			<div class="container">

		      <form class="form-signin" name='f' action='/Wiki/j_spring_security_check' method='POST'>
		        <h2 class="form-signin-heading">Please sign in</h2>
		        <label class="sr-only">Username</label>
		        <input type="text" class="form-control" name='j_username'>
		        <label class="sr-only">Password</label>
		        <input type="password" class="form-control" name='j_password' >

		        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		        
		       <div style="padding-top:1em;">
		      	<p>Not registered? <a href="/Wiki/register">Register</a></p>
		      </div>
		      
		      </form>

		</div> 
 	</div>
</body>
</html>