<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Upload Done</title>
    <c:import url="fragments/static_files.jsp"/>
</head>
<body>
<c:import url="fragments/header.jsp"/>
<!--starts body-->
<h1>${title}</h1>
<br/>
<p>${message}</p>
<a href="<c:url value="/logout" />">Logout</a>
<!--ends body-->
<c:import url="fragments/footer.jsp"/>
</body>
</html>