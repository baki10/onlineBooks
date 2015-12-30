<%@ page contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Upload Done</title>
    <c:import url="fragments/static_files.jsp"/>
</head>
<body>
    <c:import url="fragments/header.jsp"/>
    <!--starts body-->

    <form:form modelAttribute="user" class="form-horizontal" >
            <div class="control-group" id="author">
                <table>
                    <tr>
                        <td><form:label path="username">Username</form:label></td>
                        <td><form:input path="username" /></td>
                        <td><form:errors path="username" /></td>
                    </tr>
                    <tr>
                        <td><form:label path="password">Password</form:label></td>
                        <td><form:input path="password" /></td>
                        <td><form:errors path="password" /></td>
                    </tr>
                    <tr>
                        <td><form:label path="enabled">Enabled</form:label></td>
                        <td><form:checkbox path="enabled"/></td>
                        <td><form:errors path="enabled" /></td>
                    </tr>
                </table>
            </div>
            <div class="form-actions">
                <button type="submit">Add User</button>
            </div>
        </form:form>

    <!--ends body-->
    <c:import url="fragments/footer.jsp"/>
</body>
</html>