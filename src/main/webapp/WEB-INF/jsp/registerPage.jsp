<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<t:wrapper> 
<title>Register</title>
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

		      <form:form cssClass="form-signin" commandName="user" method='POST'>

		        <label class="sr-only">Username</label>
		        <form:input  cssClass="form-control"  path="username" />
		        
		        <label class="sr-only">Password</label>
		        <form:password  cssClass="form-control" path="password" />

		        <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
		        
				<div style="padding-top:0.5em;">
					Already registered? <a href = "/Wiki/login">Login</a>
				</div>
		      
		      </form:form>

		</div> 
 	</div>
	
	
	
<%-- 	 <form:form >
	 	<div>
		 	<div>
		 		Enter Username:
		 	</div>
		 	<form:input path="username" />
	 	</div>
		
		<div>
		 	<div>
		 		Enter Password:
		 	</div>
			<form:password path="password" />
		</div>
		
		<div style="padding-top:0.5em;">
			<input type="submit" class="btn" value="Save"/>
		</div>
		

	  </form:form> --%>

</body>
</html>