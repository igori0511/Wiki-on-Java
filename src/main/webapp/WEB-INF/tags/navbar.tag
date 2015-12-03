<%@tag description="Navigation Bar" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav id="custom-bootstrap-menu" class="navbar navbar-inverse" >

  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/Wiki/getallposts">Wiki</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
		<c:forTokens items="${links}" delims="," var="lin">			
    		${lin}
		</c:forTokens>
      </ul>

      <ul class="nav navbar-nav navbar-right">
        <c:forTokens items="${linksRight}" delims="," var="lin">
    		<li>${lin}</li>
		</c:forTokens>
      </ul>
    </div><!-- /.navbar-collapse -->
    
  </div><!-- /.container-fluid -->
  
</nav>