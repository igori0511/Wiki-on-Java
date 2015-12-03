<%@tag description="Frontend Libraries" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<spring:url value="/assets/css/bootstrap.min.css" var="bootstrapMinCss" />
	<spring:url value="/assets/css/navbarStyles.css" var="navBarStyles" />
	<spring:url value="/assets/css/main.css" var="mainCssStyles" />
		<spring:url value="/assets/css/signin.css" var="signInCss" />
	<spring:url value="/assets/js/jquery-1.11.3.min.js" var="jquery" />
	<spring:url value="/assets/js/bootstrap.min.js" var="bootstrapMinJs" />	
	
	
	<link href="${bootstrapMinCss}" rel="stylesheet" />
	<link href="${navBarStyles}" rel="stylesheet" />
	<link href="${mainCssStyles}" rel="stylesheet" />
	<link href="${signInCss}" rel="stylesheet" />
	<script src="${jquery}"></script>
	<script src="${bootstrapMinJs}"></script>

<title>Edit Page</title>
</head>
  
