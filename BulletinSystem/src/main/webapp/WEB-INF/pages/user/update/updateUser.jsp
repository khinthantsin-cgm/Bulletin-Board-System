<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
  <section class="content">
    <div class="row">
      <div class="col-12">
        <div class="forms-mr">
          <div class="col-sm-6 col-md-6 form-detail">
            <c:url var="addAction" value="/updateUserConfirm"></c:url>
            <form:form action="${addAction }"
              modelAttribute="oldUserForm" method="POST" id="form"
         >
              <form:hidden path="id" />
              <div class="card card-primary card-outline">
                <div class="card-body box-profile">
                  <h4 class="text-center forms-header">
                    <b>User Update</b> 
                  </h4>
                  <c:if test="${errorMsg != null }">
                    <div class="alert alert-danger">
                      <strong>${errorMsg }</strong>
                    </div>
                  </c:if>
                  <div class="form-group">
                    <label for="name">Name</label>
                    <form:input path="name" type="text"
                      class="form-control" />
                    <form:errors path="name" class="text-danger" />
                  </div>
                  <div class="form-group">
                    <label for="email">Email</label>
                    <form:input class="form-control" path="email"
                      type="text" />
                    <form:errors path="email" class="text-danger" />
                  </div>
                  <form:input path="password" type="hidden" />
                  <div class="form-group">
                    <c:if test="${LOGIN_USER.type == 0 }">
                      <label for="type">Authority</label>
                      <form:select path="type" name="type"
                        class="form-control" id="authority">
                        <form:option value="0">ADMIN</form:option>
                        <form:option value="1">USER</form:option>
                      </form:select>
                      <form:errors path="type" class="text-danger" />
                    </c:if>
                    <c:if test="${LOGIN_USER.type == 1 }">
                      <form:input path="type" type="hidden" />
                    </c:if>
                    <form:errors path="type" class="text-danger" />
                  </div>
                  <div class="form-group">
                    <label for="phone">Phone</label> <input
                      class="form-control" type="text" name="phone"
                      pattern="[0]{1}[9]{1}[0-9]{7,9}"
                      value="${oldUserForm.phone }" />
                    <form:errors path="phone" class="text-danger" />
                  </div>
                  <div class="form-group">
                    <label for="dob">Date Of Birth</label>
                    <div class="input-group date datepicker"
                      data-provide="datepicker">
                      <input class="form-control" name="dob"
                        value="${oldUserForm.dob }" />
                      <div class="input-group-addon">
                        <span class="glyphicon glyphicon-th"></span>
                      </div>
                    </div>
                    <form:errors path="dob" class="text-danger" />
                  </div>
                  <div class="form-group">
                    <label for="address">Address</label> <input
                      class="form-control" name="address"
                      value="${oldUserForm.address }" />
                  </div>
             
                  <button type="submit" class="btn btn-info">Update</button>
                  <a class="btn btn-secondary"
                    href="${pageContext.request.contextPath}/userDetail?id=${oldUserForm.id }">Back</a>
                  <button type="reset" class="btn btn-secondary">Reset</button>
                </div>
              </div>
            </form:form>
          </div>
        </div>
      </div>
    </div>
  </section>
</div>
<script src="<c:url value="/resources/js/imagePreview.js"/>"></script>