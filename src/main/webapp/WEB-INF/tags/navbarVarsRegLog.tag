<%@tag description="Navigation Bar Variables" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="allPostsActive" scope="session" value=''/>

<c:set var="link"  scope="session" value='<li class="${historyActive}"><a href = "/Wiki/_history/${symbolicName}">History</a></li>'/>
<c:set var="link2" scope="session" value='<li class="${editPostsActive}"><a href = "/Wiki/_edit/${symbolicNameEdit}">EditPost</a></li>'/>
<c:set var="link3" scope="session" value='<li class="${allPostsActive}"><a href = "/Wiki/getallposts">AllPosts</a></li>'/>
<c:set var="link4" scope="session" value='<li class="${viewCurrentActive}"><a href = "/Wiki/${symbolicNameEdit}">View Current Post</a></li>'/>
<c:set var="link5" scope="session" value='<li><a href = "/Wiki/logout">Logout</a></li>'/>
	
<c:set var="historyActive" scope="session" value=''/>
<c:set var="editPostsActive" scope="session" value=''/>

<c:set var="viewCurrentActive" scope="session" value=''/>


<c:set var="links" scope="session" >${link},${link2},${link3},${link4}</c:set>
<c:set var="linksRight" scope="session" >${link5},</c:set>