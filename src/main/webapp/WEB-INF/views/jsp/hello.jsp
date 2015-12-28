<%@ page contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>home</title>
    <c:import url="fragments/static_files.jsp"/>
</head>
    <c:import url="fragments/header.jsp"/>

  <div class="container">
	<h1>${title}</h1>
  </div>
 
<div class="container">
 
  <div class="row">
	<div class="col-md-4">
		<h2>Show all Books</h2>
		<p>Get me all books from database</p>
		<p>
			<a class="btn btn-primary btn-lg" href="<c:url value="/books/all"/>"  role="button">All Books</a>
		</p>
	</div>
	<div class="col-md-4">
		<h2>Uploaded files</h2>
		<p>Uploaded files to database</p>
		<p>
			<a class="btn btn-primary btn-lg" href="<c:url value="/uploadedFiles"/>"  role="button">Uploaded files</a>
		</p>
	</div>

  </div>

    <c:import url="fragments/footer.jsp"/>
</body>
</html>