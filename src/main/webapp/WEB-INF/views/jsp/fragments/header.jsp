<%@ page contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
	<div class="navbar-header">
		<a class="navbar-brand" href="<c:url value="/home"/>">Online Library</a>
	</div>
	<div class="navbar-right" style="margin-top: 8px; color:white">
         <c:if test="${not empty name}">
        	Hello, ${name}! <a  href="<c:url value="/endSession"/>">End session</a>
         </c:if>

         <c:if test="${empty name}">
            <fmt:message key="welcome"/>
         </c:if>
    </div>
  </div>
</nav>
<div class="jumbotron">
