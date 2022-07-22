<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bulletin System| Post Detail</title>
<link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>
<body>
	<div class="wrapper">
		<div class="sec-list">
			<div class="container">
				<div class="detail-box">
					<div class="content clearfix">

						<div class="detail-sec clearfix">

							<ul class="detail-list">
								<li>
									<table class="detail-tbl">
										<tr>
											<th><span class="detail-label">Name</span></th>
											<td>${userDetail.name}</td>
										</tr>
									</table>
								</li>

								<li>
									<table class="detail-tbl">
										<tr>
											<th><span class="detail-label">Email</span></th>
											<td>${userDetail.email}</td>
										</tr>
									</table>
								</li>

								<li>
									<table class="detail-tbl">
										<tr>
											<th><span class="detail-label">Address</span></th>
											<td>${userDetail.address}</td>
										</tr>
									</table>
								</li>

								<li>
									<table class="detail-tbl">
										<tr>
											<th><span class="detail-label">Phone</span></th>
											<td>${userDetail.phone}</td>
										</tr>
									</table>
								</li>

								<li>
									<table class="detail-tbl">
										<tr>
											<th><span class="detail-label">Date Of Birth</span></th>
											<td>${userDetail.dob}</td>
										</tr>
									</table>
								</li>

							</ul>
						</div>
					</div>



					<a href="${pageContext.request.contextPath}/userList"
						class="cmn-link">Back</a>




				</div>
			</div>
		</div>
	</div>
</body>
</html>