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
<a	href="${pageContext.request.contextPath}/createUser"
    								class="cmn-link">Add</a>
 <table 
                  class="tbl">
               
                    <tr>
                      <th>ID</th>
                      <th>Name</th>
                      <th>Email</th>
                  
                  
                      <th>Phone</th>
                     
                      <th>Created At</th>
                 
                        <th>Actions</th>
                     
                    </tr>
               
                    <c:forEach items="${UserList}" var="user"
                      varStatus="loop">
                      
                          <tr>
                            <td>${user.id }</td>
                            <td><a
                  href="<c:url value='userDetail?id=${user.id}'/>"
                  class="medicine-link">${user.name }</a></td>
                            <td>${user.email }</td>
                           
                        
                          
                            <td>${user.phone }</td>
                          
                            <td><fmt:formatDate
                                pattern="dd/MM/yyyy"
                                value="${user.createdAt }" /></td>
                         
                              <td class="text-right py-0 align-middle">
                                <div class="btn-group btn-group-sm">
                                <a class="cmn-link"
    								href="${pageContext.request.contextPath}/updateUser?id=${user.id}">Update</a>
                                  <a
                                    href="<c:url value='detailUser?id=${user.id}'/>"
                                    class="btn btn-info"><i
                                    class="fas fa-eye"></i></a> 	<a
    								href="${pageContext.request.contextPath}/deleteUser?id=${user.id}"
    								class="cmn-link"
    								onclick="if (!(confirm('Are you sure you want to delete this post?'))) return false">Delete</a>
                                </div>
                              </td>
                         
                          </tr>
                   
                      </c:forEach>
             
                 
                </table>
                	<a	href="${pageContext.request.contextPath}/logout"
    								class="cmn-link">Logout</a>
                </div>
		</div>
	</div>
</body>
</html>