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
<form:form action="createUserConfirm"
              modelAttribute="rollBackUserForm" method="POST" id="form"
              role="form" >
              <div class="card card-primary card-outline">
                <div class="card-body box-profile">
                
                  <c:if test="${errorMsg != null }">
                    <div class="alert alert-danger">
                      <strong>${errorMsg }</strong>
                    </div>
                  </c:if>
                  <div class="form-group">
                    <label for="name">Name</label>
                    <form:input path="name"
                      value="${rollBackUserForm.name }"
                      class="form-control" placeholder="Enter Name" />
                    <div class="input-group">
                      <form:errors path="name"
                        class="has-error text-danger" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="email">Email</label>
                    <form:input path="email"
                      value="${rollBackUserForm.email }"
                      class="form-control" placeholder="Enter Email"
                      autocomplete="false" />
                    <div class="input-group">
                      <form:errors path="email"
                        class="has-error text-danger" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="password">Password</label>
                    <form:password path="password"
                      value="${rollBackUserForm.password }"
                      class="form-control" placeholder="Enter Password" />
                    <div class="input-group">
                      <form:errors path="password"
                        class="has-error text-danger" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label>Confirm Password</label> <input
                      type="password" name="confirmPassword"
                      class="form-control"
                      value="${rollBackUserForm.password }"
                      placeholder="Enter Confirm Password" />
                  </div>
                  <div class="form-group">
                    <label for="type">Authority</label>
                    <form:select path="type" id="authority"
                      class="form-control"
                      value="${rollBackUserForm.type }">
                      <option value="0">Admin</option>
                      <option value="1">User</option>
                    </form:select>
                    <div class="input-group">
                      <form:errors path="type"
                        cssClass="has-error text-danger" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="phone">Phone</label>
                    <form:input type="text" path="phone"
                      pattern="[0]{1}[9]{1}[0-9]{7,9}"
                      value="${rollBackUserForm.phone }"
                      class="form-control" placeholder="Enter Phone" />
                    <div class="input-group">
                      <form:errors path="phone"
                        cssClass="has-error text-danger" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="dob">Date Of Birth</label>
                    <div class="input-group date datepicker"
                      data-provide="datepicker">
                      <form:input value="${rollBackUserForm.dob }"
                        path="dob" type="text" class="form-control"
                        placeholder="Enter Date Of Birth" />
                      <div class="input-group-addon">
                        <span class="glyphicon glyphicon-th"></span>
                      </div>
                    </div>
                    <div class="input-group">
                      <form:errors path="dob"
                        cssClass="has-error text-danger" />
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="address">Address</label>
                    <form:textarea path="address"
                      value="${rollBackUserForm.address }"
                      class="form-control" placeholder="Enter Address"></form:textarea>
                  </div>
              
                  <button type="submit" class="btn btn-info"
                    name="confirmUser">Confirm</button>
                  <a class="btn btn-secondary"
                    href="${pageContext.request.contextPath}/userList">Back</a>
                  <a class="btn btn-secondary"
                    href="${pageContext.request.contextPath}/createUser">ClearAll</a>
                </div>
              </div>
            </form:form>
            </div>
			</div>
		</div>
	</div>
	<script src="<c:url value="/resources/js/imagePreview.js"/>"></script>
</body>
</html>
