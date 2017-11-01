<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:wrapper>

    <jsp:attribute name="header">
        <%@include file="../common/header.jsp" %>
        <%@include file="../common/userprofile.jsp" %>
        <%@include file="../common/menu.jsp" %>
    </jsp:attribute>
    <jsp:attribute name="footer">
         <%@include file="../common/footer.jsp" %>
    </jsp:attribute>

    <jsp:body>
        <div class="content-wrapper">

            <form:form action="${rc.getContextPath()}/user/addUser" method="post" commandName="userForm">
                <c:set var="checkUserIdExist" value="${userForm.userId != null && userForm.userId > 0}"/>
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h4 class="page-head-line">${checkUserIdExist?"Update":"Add"} User </h4>
                        </div>
                    </div>
                    <div class="row">
                        <c:if test="${not empty error}">
                            <span class="text-danger">${error}</span>
                        </c:if>
                        <div class="col-md-6">
                            <div class="panel panel-default">
                                <div class="panel-body">

                                    <div class="form-group">
                                        <label for="exampleInputName">NAME </label><span
                                            class="text-danger"><form:errors path="name" /></span>
                                        <form:input id="exampleInputName" path="name" cssClass="form-control"
                                                    placeholder="Enter Name" />
                                    </div>

                                    <div class="form-group">
                                        <label for="exampleInputEmail1">USER NAME </label><span
                                            class="text-danger"><form:errors path="userName" /></span>
                                        <form:input id="exampleInputEmail1" path="userName" cssClass="form-control"
                                                    cssStyle="display: ${checkUserIdExist?'none':''}"
                                                    placeholder="Enter UserName"  />
                                        <span ${checkUserIdExist?'':'hidden'}>   ${userForm.userName}  </span>
                                    </div>

                                    <div class="form-group">
                                        <label for="exampleInputPassword1">PASSWORD </label><span
                                            class="text-danger"><form:errors path="password" /></span>
                                        <form:password id="exampleInputPassword1" path="password" cssClass="form-control"
                                                    placeholder="Enter Password" />
                                    </div>

                                    <div class="form-group">
                                        <label for="exampleInputPassword1">DEPARTMENT </label>
                                        <form:select cssClass="form-control" path="departmentId" >
                                            <c:if test="${not empty departments}">
                                                <c:forEach items="${departments}" var="department">
                                                    <form:option value="${department.departmentId}" label="${department.departmentName}"></form:option>
                                                </c:forEach>
                                            </c:if>
                                        </form:select>
                                    </div>

                                    <div class="form-group">
                                        <label for="exampleInputPassword1">POSITION </label>
                                        <div class="radio-menu-item">
                                            <c:if test="${not empty positions}">
                                                <c:forEach items="${positions}" var="position">
                                                    <form:radiobutton value="${position.positionId}"
                                                                      path="positionId"
                                                                      label="${position.positionName}"></form:radiobutton>
                                                </c:forEach>
                                            </c:if>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="exampleInputPassword1">TITLE </label>
                                        <div class="radio-menu-item">
                                            <c:if test="${not empty titles}">
                                                <c:forEach items="${titles}" var="title">
                                                    <form:radiobutton  value="${title.titleId}" path="titleId"
                                                                       label="${title.titleName}"></form:radiobutton>
                                                </c:forEach>
                                            </c:if>
                                        </div>
                                    </div>

                                    <div class="row" style="margin-left: 0px;">
                                        <button type="submit"
                                                class="btn btn-default" style="display: ${checkUserIdExist?"none":"table"}" >Submit
                                        </button>

                                        <button formaction="${rc.getContextPath()}/user/updateUser?userId=${userForm.userId}"
                                                class="btn btn-default" style="display: ${checkUserIdExist?"table":"none"}">Update
                                        </button>
                                    </div>
                                    <hr/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </form:form>

        </div>
    </jsp:body>
</t:wrapper>