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

            <form:form action="${rc.getContextPath()}/department/add" method="post" commandName="departmentForm">
                <c:set var="checkDepartmentIdExist" value="${departmentForm.departmentId != null && departmentForm.departmentId > 0}"/>
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h4 class="page-head-line">${checkDepartmentIdExist?"Update":"Add"} New Department </h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="panel panel-default">
                                <div class="panel-body">

                                    <div class="form-group">
                                        <label for="exampleInputName">NAME </label><span
                                            class="text-danger"><form:errors path="departmentName" /></span>
                                        <form:input id="exampleInputName" path="departmentName" cssClass="form-control"
                                                    placeholder="Enter Department Name" />
                                    </div>

                                    <button type="submit"
                                            class="btn btn-default" style="display: ${checkDepartmentIdExist?"none":"table"}">Submit
                                    </button>

                                    <button formaction="${rc.getContextPath()}/department/update?departmentId=${departmentForm.departmentId}"
                                            class="btn btn-default" style="display: ${checkDepartmentIdExist?"table":"none"}">Update
                                    </button>
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