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
 
  <div class="row">
    <p>
		<a class="btn btn-primary btn-lg" href="<c:url value="/books/createRandomBook"/>"  role="button">Create Random Book</a>
	</p>
    <p>
		<a class="btn btn-primary btn-lg" href="<c:url value="/books/downloadPDF"/>"  role="button">Books in pdf</a>
	</p>
    <p>
		<a class="btn btn-primary btn-lg" href="<c:url value="/books/new"/>"  role="button">Add Book</a>
	</p>
        <div class="table-responsive cart_info">
             <table class="table table-condensed">
                   <thead>
                        <tr>
                            <td>ID</td>
                            <td>Title</td>
                            <td>Description</td>
                                    <td>Author</td>
                                    <td>Photo</td>
                                    <td>Date</td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${books}" var="i">
                                    <tr>
                                        <td>${i.id}</td>
                                        <td>${i.title}</td>
                                        <td>${i.description}</td>
                                        <td>${i.author.name}</td>
                                        <td>${i.photo.fileName}</td>
                                        <td>${i.published}</td>
                                        <td>
                                            <a class="btn btn-primary" href="<c:url value="/books/${i.id}/edit"/>"  role="button">Edit Book</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
  </div>
 

    <c:import url="fragments/footer.jsp"/>
</body>
</html>