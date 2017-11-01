<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:wrapper>
    <jsp:attribute name="header">
        <%@include file="../common/header.jsp" %>
        <%@include file="../common/userprofile.jsp" %>
    </jsp:attribute>
    <jsp:attribute name="footer">
         <%@include file="../common/footer.jsp" %>
    </jsp:attribute>

    <jsp:body>
        <div class="content-wrapper">

            <form:form method="post" commandName="loginForm">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h4 class="page-head-line">Please Login To Enter </h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <h4> Login with <strong>WINTER :</strong></h4>
                            <br/>

                            <label>Enter ID : </label><span color="red"><form:errors path="userName" /></span>
                            <form:input path="userName" cssClass="form-control" />

                            <label>Enter Password : </label><span color="red"><form:errors path="password" /></span>
                            <form:password path="password" cssClass="form-control" />
                            <hr/>

                            <button formaction="${rc.getContextPath()}/login" class="btn btn-info"><span class="glyphicon glyphicon-user"></span>&nbsp;Log Me In</button>&nbsp;
                        </div>
                    </div>
                </div>
            </form:form>

        </div>
    </jsp:body>
</t:wrapper>