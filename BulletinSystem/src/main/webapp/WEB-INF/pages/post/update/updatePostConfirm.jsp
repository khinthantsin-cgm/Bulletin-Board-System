<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
  <div class="wrapper">
    <div class="sec-list">
      <div class="container">
        <div class="sec-form">
          <h2 class="cmn-ttl">Post Update Confirm Form</h2>
          <c:url var="updatePostConfirm" value="/editPost"></c:url>
          <form:form class="form clearfix" action="editPost"
            method="POST" id="form" modelAttribute="updatePostForm">
            <form:input type="hidden" path="id" />
            <ul class="confirm-list">
              <li><b>Title</b> <a class="input">${updatePostForm.title}
                  <input type="hidden" name="title"
                  value="${updatePostForm.title}" />
              </a></li>
              <li><b>Description</b> <a class="input">${updatePostForm.description}
                  <input type="hidden" name="description"
                  value="${updatePostForm.description}" />
              </a></li>
            </ul>
            <div class="clearfix">
              <button type="submit" class="cmn-btn" name="update">Update</button>
              <button type="submit" class="cmn-btn" name="cancel">Cancel</button>
            </div>
          </form:form>
        </div>
      </div>
    </div>
  </div>
</body>
</html>