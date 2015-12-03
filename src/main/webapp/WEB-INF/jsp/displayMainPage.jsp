<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<!DOCTYPE html>
<html>
<t:wrapper> 
	<title>Current Post</title>
</t:wrapper>
<body>	

	<c:set var="viewCurrentActive"  scope="session" value='active'/>
	<t:navbarVars/>
	
	<t:navbar/>	

	<div class="container">
		<h1>CURRENT POST:</h1>	
		
		<div style=" font-size: 1.2em; text-align: justify;">
			${currentPost}
		</div>
	</div>
	
</body>

</html>