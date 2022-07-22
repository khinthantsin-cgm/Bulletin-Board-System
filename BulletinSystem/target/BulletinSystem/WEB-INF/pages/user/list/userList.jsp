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
				<h2 class="cmn-ttl">User List</h2>
				<c:if test="${completeMsg != null  && completeMsg != ''}">
					<div class="alert alert-success">
						<strong>${completeMsg }</strong>
					</div>
				</c:if>
				<c:remove var="completeMsg" />

 <table id="example1"
                  class="tbl">
               
                    <tr>
                      <th>ID</th>
                      <th>Name</th>
                      <th>Email</th>
                      <c:if test="${LOGIN_USER.type == 1 }">
                        <th>Created User</th>
                      </c:if>
                      <th>Phone</th>
                      <th>Birth Date</th>
                      <th>Address</th>
                      <th>Created At</th>
                      <c:if test="${LOGIN_USER.type == 1 }">
                        <th>Actions</th>
                      </c:if>
                    </tr>
               
                    <c:forEach items="${UserList}" var="user"
                      varStatus="loop">
                              <!--  <c:forEach items="${createUserName}"
                        var="createdUser" varStatus="loop">
            <c:if test="${user.id == createdUser.id }"> -->   
                          <%-- <c:if test="${LOGIN_USER.id != user.id }"> --%>
                          <tr>
                            <td>${user.id }</td>
                            <td>${user.name }</td>
                            <td>${user.email }</td>
                           
                              <td>${createdUser.name }</td>
                          
                            <td>${user.phone }</td>
                            <td>${user.dob }</td>
                            <td>${user.address }</td>
                            <td><fmt:formatDate
                                pattern="dd/MM/yyyy"
                                value="${user.createdAt }" /></td>
                         
                              <td class="text-right py-0 align-middle">
                                <div class="btn-group btn-group-sm">
                                  <a
                                    href="<c:url value='detailUser?id=${user.id}'/>"
                                    class="btn btn-info"><i
                                    class="fas fa-eye"></i></a> <a href="#"
                                    data-toggle="modal"
                                    data-href="${pageContext.request.contextPath}/detailUser?id=${user.id }"
                                    data-target="#myModal"
                                    class="btn btn-danger"><i
                                    class="fas fa-trash"></i></a>
                                </div>
                              </td>
                         
                          </tr>
                     <!--   </c:if> --> 
                      </c:forEach>
                   <!--   </c:forEach>--> 
                 
                </table>
                </div>
		</div>
	</div>
</body>
</html>