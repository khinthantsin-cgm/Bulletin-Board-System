<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
				<h2 class="cmn-ttl">Post List</h2>
				<c:if test="${completeMsg != null  && completeMsg != ''}">
					<div class="alert alert-success">
						<strong>${completeMsg }</strong>
					</div>
				</c:if>
				<c:remove var="completeMsg" />

			<!--  	<div class="search-sec">
					<c:url var="addAction" value="/searchCategory"></c:url>
					<form:form action="${addAction}" modelAtrribute="categoryForm"
						method="post" id="form">
						<ul class="btn-list clearfix">
							<li><label><input type="text"
									class="search-box description-txt"
									aria-controls="example1" name="search-input"
									value="${searchData }" placeholder="Search..."></label></li>
							<li><input name="searchCategory" type="submit"
								value="Search" class="cmn-link"></li>
                            <c:if test="${LOGIN_USER.type == '0' }">
    							<li><a
    								href="${pageContext.request.contextPath}/createCategory"
    								class="cmn-link">Add</a></li>
                            </c:if>

							<%-- <c:if test="${!empty CategoryList }">
								<li><input type="submit" class="cmn-link" value="Download"
									name="downloadExcel"></li>
							</c:if> --%>
						</ul>
					</form:form>
				</div>
-->
    						<a	href="${pageContext.request.contextPath}/createPost"
    								class="cmn-link">Add</a>
				<table class="tbl">
					<c:if test="${errorMsg != null }">
						<div class="alert alert-danger">
							<strong>${errorMsg }</strong>
						</div>
					</c:if>
					<tr>
						<th>Title</th>
						<th>Description</th>
                     
						  <th>Action</th>
                       
					</tr>
					<c:forEach items="${PostList}" var="post" varStatus="loop">
						<tr>
							<td><a
                  href="<c:url value='postDetail?id=${post.id}'/>"
                  class="medicine-link">${post.title}</a></td>
							<td>${post.description}</td>
                      
    							<td><a class="cmn-link"
    								href="${pageContext.request.contextPath}/updatePost?id=${post.id}">Update</a>
    								<a
    								href="${pageContext.request.contextPath}/deletePost?id=${post.id}"
    								class="cmn-link"
    								onclick="if (!(confirm('Are you sure you want to delete this post?'))) return false">Delete</a></td>
                          
						</tr>
					</c:forEach>
				</table>
   <a	href="${pageContext.request.contextPath}/createUser"
    								class="cmn-link">Add User</a>
			</div>
		</div>
	</div>
</body>
</html>