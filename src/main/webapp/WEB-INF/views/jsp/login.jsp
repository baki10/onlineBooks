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
<div class="container" style="width: 300px;">

    <form action="<c:url value="/login" />" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control" name="username" placeholder="Email address" required autofocus
               value="baki">
        <input type="password" class="form-control" name="password" placeholder="Password" required value="b">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
    </form>
</div>
<!--ends body-->
<c:import url="fragments/footer.jsp"/>
</body>
</html>