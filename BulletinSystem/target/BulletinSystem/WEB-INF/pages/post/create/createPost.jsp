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
					<h2 class="cmn-ttl">Post Create Form</h2>

					<form:form class="form clearfix" action="createPostConfirm"
						method="POST" id="form" modelAttribute="createPostForm">

						<c:if test="${errorMsg != null }">
							<div class="alert alert-danger">
								<strong>${errorMsg }</strong>
							</div>
						</c:if>

						<label for="title" class="required">Title</label>
						<form:input path="title" value="${createPostForm.title }"
							class="input" placeholder="Enter Post Title" />
						<form:errors path="title" class="text-danger error" />

						<label for="description" class="required">Description</label>
						<form:textarea path="description"
							value="${createPostForm.description }" class="input"
							placeholder="Enter Post Description" />
						<form:errors path="description" class="text-danger error" />

						<div class="form-cmn-btn clearfix">
							<button type="submit" class="cmn-btn" name="confirmPost">Confirm</button>
							<button type="reset" class="cmn-btn" name="clear">Reset</button>
							<a href="${pageContext.request.contextPath}/postList"
								class="cmn-btn ">BACK</a>
						</div>
					</form:form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>