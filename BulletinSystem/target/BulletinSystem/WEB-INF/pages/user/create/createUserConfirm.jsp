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
					<h2 class="cmn-ttl">User Sign-up Form</h2>
 <form:form action="insertUser" modelAttribute="userForm"
              method="POST" id="form">
              <input type="hidden" name="id" value="${userForm.id }">
              <div class="card card-primary card-outline">
                <div class="card-body box-profile">
                  <h4 class="text-center forms-header">
                    <b>Created User Confirm</b>
                  </h4>
                  <c:if test="${errorMsg != null }">
                    <div class="alert alert-danger">
                      <strong>${errorMsg }</strong>
                    </div>
                  </c:if>
                  <ul class="list-group list-group-unbordered mb-3">
                    <li class="list-group-item"><b>Name</b> <a
                      class="float-right">${userForm.name } <form:input
                          path="name" type="hidden" name="name"
                          value="${userForm.name }" class="form-control" /></a></li>
                    <li class="list-group-item"><b>Email</b> <a
                      class="float-right">${userForm.email } <form:input
                          path="email" type="hidden" name="email"
                          value="${userForm.email }"
                          class="form-control" /></a></li>
                    <li class="list-group-item"><b>Password</b> <a
                      class="float-right">******** <form:input
                          path="password" type="hidden" name="password"
                          value="${userForm.password }"
                          class="form-control" /></a></li>
                    <li class="list-group-item"><b>Type</b> <c:if
                        test="${userForm.type == 0 }">
                        <a class="float-right">ADMIN <form:input
                            path="type" type="hidden" name="type"
                            value="${userForm.type }"
                            class="form-control" /></a>
                      </c:if> <c:if test="${userForm.type == 1 }">
                        <a class="float-right">USER <form:input
                            path="type" type="hidden" name="type"
                            value="${userForm.type }"
                            class="form-control" /></a>
                      </c:if></li>
                    <li class="list-group-item"><b>Phone</b> <a
                      class="float-right">${userForm.phone } <form:input
                          path="phone" type="hidden" name="phone"
                          value="${userForm.phone }"
                          class="form-control" /></a></li>
                    <li class="list-group-item"><b>Date Of
                        Birth</b> <a class="float-right">${userForm.dob }
                        <form:input path="dob" type="hidden" name="dob"
                          value="${userForm.dob }" class="form-control" />
                    </a></li>
                    <li class="list-group-item"><b>Address</b> <a
                      class="float-right">${userForm.address } <form:input
                          path="address" type="hidden" name="address"
                          value="${userForm.address }"
                          class="form-control" /></a></li>
                    <li class="list-group-item"><b>Image</b> <c:if
                        test="${userForm.image == ''}">
                        <form:input path="image" type="hidden"
                          name="image" value="${userForm.image }"
                          class="form-control" />
                      </c:if> <c:if test="${userForm.image != ''}">
                        <a class="float-right"> <img
                          src="${userForm.image }" id="image"
                          class="profile-user-img img-fluid img-circle" />
                          <form:input path="image" type="hidden"
                            name="image" value="${userForm.image }"
                            class="form-control" /></a>
                      </c:if></li>
                  </ul>
                  <button type="submit" class="btn btn-info"
                    name="addUser">Add</button>
                  <button type="submit" class="btn btn-secondary"
                    name="cancel">Cancel</button>
                </div>
              </div>
            </form:form>
              </div>
			</div>
		</div>
	</div>
</body>
</html>