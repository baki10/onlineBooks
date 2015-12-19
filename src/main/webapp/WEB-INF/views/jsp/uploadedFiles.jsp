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
  <h2>Upload files</h2>
  <p>Upload files to database</p>
  <p>
     <a class="btn btn-primary btn-lg" href="<c:url value="/uploadFile"/>"  role="button">Upload files</a>
  </p>
  <div class="row">
        <div class="table-responsive cart_info">
             <table class="table table-condensed">
                   <thead>
                        <tr>
                            <td>FILE_ID</td>
                            <td>FILE_DATA</td>
                            <td>FILE_NAME</td>
                            <td></td>
                        </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${files}" var="i">
                                   <form method="post" action="uploadedFile" >
                                    <tr>
                                        <td>${i.id}</td>
                                        <td>${i.data}</td>
                                        <td>${i.fileName}</td>
                                        <td>
                                        <input type="hidden" name="fileId" value=${i.id} />
                                        <input type="submit" name="form${i.id}" value = "Open"/>
                                        </td>
                                    </tr>
                                    </form>
                                </c:forEach>
                            </tbody>
                        </table>

  </div>

    <c:import url="fragments/footer.jsp"/>
</body>
</html>