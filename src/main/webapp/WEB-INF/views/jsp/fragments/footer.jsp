<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<hr>
  <footer>
	<p>&copy; Bakigoal 2015</p>
  </footer>

<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>