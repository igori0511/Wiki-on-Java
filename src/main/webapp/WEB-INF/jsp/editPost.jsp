<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
 
<!DOCTYPE html>
<html>
<t:wrapper> 
<title>Edit post</title>
</t:wrapper>
<body>

	<c:set var="editPostsActive" scope="session" value='active'/>
	
	<t:navbarVars/>
	
	<t:navbar/>		
	
	<div class="container">
		 <form:form commandName="post">
		 	<div class="form-group">
		 		<label for="comment">Edit post:</label>
				<form:textarea path="postData" cssClass="form-control" cssStyle="height:40em; resize:none;"/>		
				<div style="padding-top:1em;">
					<input type="submit" class="btn btn-success btn-lg" value="Save"/>
				</div>		
			</div>	
		 </form:form>
	</div>
	 
</body>
</html>