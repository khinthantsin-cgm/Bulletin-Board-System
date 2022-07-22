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
					<div class="user-name">${postDetail.createdUserName}<br><span class="created-date">${postDetail.createdAt }</span></div>
					<div class="content clearfix">
					<div class="img-sec">
							<c:if test="${empty postDetail.image }">
								<img src="<c:url value='/resources/img/noimage.png'/>"
									alt="User profile picture">
							</c:if>
							<c:if test="${not empty postDetail.image }">
								<img src="${postDetail.image}" />
							</c:if>
						</div>
						<div class="detail-sec clearfix">

							<ul class="detail-list">
								<li>
								<table class="detail-tbl">
								<tr>
										<th><span class="detail-label">${postDetail.title}</span></th>
										<td></td>
										</tr>
									</table>
									</li>

								<li>
								<table class="detail-tbl">
								<tr>
										<th>${postDetail.description}</th>
										<td></td>
										</tr>
									</table>
								</li>

								<li>
							
								</li>
							</ul>
						</div>
					</div>
					

					
						<a href="${pageContext.request.contextPath}/postList"
							class="cmn-link">Back</a>
					
						
                         
                       
                          </div>
			</div>
		</div>
	</div>
</body>
</html>