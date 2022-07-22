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
					<h2 class="cmn-ttl">Post Create Confirm</h2>

					<c:url var="createPostConfirm" value="/insertPost"></c:url>
					<form:form class="form clearfix" action="insertPost" method="POST"
						id="form" modelAttribute="postForm">
						<c:if test="${errorMsg != null }">
							<div class="alert alert-danger">
								<strong>${errorMsg }</strong>
							</div>
						</c:if>

						<input type="hidden" name="id" value="${postForm.id }">

						<ul class="confirm-list">
							<li><b>Title</b> <a class="input">${postForm.title} <form:input
										path="title" type="hidden" name="title"
										value="${postForm.title}" class="form-control" />
							</a></li>

	<li><b>Description</b> <a class="input">${postForm.description} <form:input
										path="description" type="hidden" name="description"
										value="${postForm.description}" class="form-control" />
							</a></li>
						</ul>
						<div class="clearfix">
							<button type="submit" class="cmn-btn" name="addPost">Add</button>
							<button type="submit" class="cmn-btn" name="cancel">Cancel</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>