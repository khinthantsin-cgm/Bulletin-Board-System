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
          <h2 class="cmn-ttl">Post Update Form</h2>
          <c:url var="updatePost" value="/updatePostConfirm"></c:url>
          <form:form class="form clearfix"
            action="updatePostConfirm" method="POST" id="form"
            modelAttribute="editPostForm">
            <c:if test="${errorMsg != null }">
              <div class="alert alert-danger">
                <strong>${errorMsg }</strong>
              </div>
            </c:if>
            <form:input type="hidden" path="id"
              value="${editPostForm.id}" />
            <label for="title">Title</label>
            <input class="input" type="text" name="title"
              value="${editPostForm.title}" />
          
            <label for="description">Description</label>
            <input class="input" type="text" name="description"
              value="${editPostForm.description}" />
           
            <div class="clearfix update-btn">
              <button type="submit" class="cmn-btn">Update</button>
              <a class="cmn-btn"
                href="${pageContext.request.contextPath}/updatePost?id=${editPostForm.id}">Reset</a>
              <a class="cmn-btn"
                href="${pageContext.request.contextPath}/postList">Back</a>
            </div>
          </form:form>
        </div>
      </div>
    </div>
  </div>
</body>
</html>