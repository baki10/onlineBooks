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

    <form:form modelAttribute="book" class="form-horizontal" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${book.id}"/>
            <div class="control-group" id="author">
                <table>
                    <tr>
                        <td><form:label path="title">Title</form:label></td>
                        <td><form:input path="title" /></td>
                        <td><form:errors path="title" /></td>
                    </tr>
                    <tr>
                        <td><form:label path="description">Description</form:label></td>
                        <td><form:input path="description" /></td>
                        <td><form:errors path="description" /></td>
                    </tr>
                    <tr>
                        <td><form:label path="published">Published year</form:label></td>
                        <td><form:select path="published" items="${yearList}" /></td>
                        <td><form:errors path="published" /></td>
                    </tr>
                    <tr>
                        <td><form:label path="author.name">Author name</form:label></td>
                        <td><form:input path="author.name" /></td>
                        <td><form:errors path="author.name" /></td>
                    </tr>
                    <tr>
                        <td><b>Please select a file to upload :</b></td>
                        <td><input type="file" name="file"/></td>
                    </tr>
                </table>
            </div>
            <div class="form-actions">
                <c:choose>
                    <c:when test="${book.id==null}">
                        <button type="submit">Add Book</button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit">Update Book</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </form:form>

    <!--ends body-->
    <c:import url="fragments/footer.jsp"/>
</body>
</html>