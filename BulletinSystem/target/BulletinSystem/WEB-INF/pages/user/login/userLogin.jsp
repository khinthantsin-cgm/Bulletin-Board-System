<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
  <div class="wrapper">
    <div class="container">
      <div class="sec-form">
        <div class="cmn-ttl">Login</div>
        <c:if test="${not empty errorMsg}">
          <div class="alert alert-danger text-center" role="alert">
            ${errorMsg}</div>
        </c:if>
        <c:url value="/login" var="loginUrl" />
        <form:form action="${loginUrl}" method="POST"
          class="form clearfix login">
          <input type="hidden" name="${_csrf.parameterName}"
            value="${_csrf.token}" />

          <label for="email">E-Mail Address</label>
          <input type="email" name="email" id="email"
            class="input description-txt" />
          <span class="form-text"> <strong></strong>
          </span>
          <label for="password" class="control-label">Password</label>
          <input type="password" name="password" id="password"
            class="input description-txt" />
          <span class="form-text"> <strong></strong>
          </span>
        
          <button type="submit" class="cmn-btn">Login</button>
          <div class="clearfix">
            <c:url value="/password/reset" var="pwReset" />
            <a href="#" class="medicine-link"></a>
        
            <a  href="${pageContext.request.contextPath}/createUser" class="medicine-link">Sign Up?</a>

          </div>
        </form:form>
      </div>
    </div>
  </div>
</body>
</html>
