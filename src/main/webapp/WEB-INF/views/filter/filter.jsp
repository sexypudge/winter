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
        <script src="${rc.getContextPath()}/resources/js/jquery-3.2.1.js"></script>
        <script language="JavaScript">

            var departmentId = 0 ;
            var titleId = 0 ;
            var positionId = 0 ;

            $(document).ready(function() {

                $(".select").change(function () {

                    /*$(".select").each(function () {
                        if($(this).attr("name")=== ("department")){
                            console.log( "Department Selected - " + $(this).val());
                            departmentId = $(this).val();
                        }

                        if($(this).attr("name") === ("title")){
                            console.log( "Title Selected - " + $(this).val());
                            titleId = $(this).val();
                        }

                        if($(this).attr("name") === ("position")){
                            console.log( "Position Selected - " + $(this).val());
                            positionId = $(this).val();
                        }
                    });*/

                    $("#form").submit();

                });

            });


        </script>
        <div class="content-wrapper">
            <form id="form" name="filterForm" method="post" action="${rc.getContextPath()}/filter/search">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h4 class="page-head-line"> User Filter </h4>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Filter Condition
                                </div>
                                <div class="panel-body">
                                    <div class="row form-inline">

                                        <div class="col-sm-1">
                                            <div class="form-group">
                                                <a href="${rc.getContextPath()}/filter/">Default</a>
                                            </div>
                                        </div>

                                        <div class="col-sm-4">
                                            <div class="form-group">
                                                <label >Department:</label>
                                                <select name="de" class="form-control select">
                                                    <option value="0">
                                                            --- SELECT DEPARTMENT ---
                                                    </option>
                                                    <c:if test="${not empty departments}">
                                                        <c:forEach items="${departments}" var="department">
                                                            <option value="${department.departmentId}"
                                                                ${filterForm.de == department.departmentId?"selected":""}>
                                                                    ${department.departmentName}
                                                            </option>
                                                        </c:forEach>
                                                    </c:if>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-sm-3">
                                            <div class="form-group">
                                                <label >Title:</label>
                                                <select name="ti" class="form-control select">
                                                    <option value="0" >
                                                        --- SELECT TITLE ---
                                                    </option>
                                                    <c:if test="${not empty titles}">
                                                        <c:forEach items="${titles}" var="title">
                                                            <option value="${title.titleId}"
                                                                ${filterForm.ti == title.titleId?"selected":""}>
                                                                    ${title.titleName}
                                                            </option>
                                                        </c:forEach>
                                                    </c:if>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-sm-3">
                                            <div class="form-group">
                                                <label >Position:</label>
                                                <select name="po" class="form-control select">
                                                    <option value="0">
                                                        --- SELECT POSITION ---
                                                    </option>
                                                    <c:if test="${not empty positions}">
                                                        <c:forEach items="${positions}" var="position">
                                                            <option value="${position.positionId}"
                                                                ${filterForm.po == position.positionId?"selected":""}>
                                                                    ${position.positionName}
                                                            </option>
                                                        </c:forEach>
                                                    </c:if>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="panel panel-danger">
                                <div class="panel-heading">
                                    Search Result
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover">
                                            <thead>
                                            <tr>
                                                <th class="text-center">#</th>
                                                <th class="text-center">Name</th>
                                                <th class="text-center">Department</th>
                                                <th class="text-center">Title</th>
                                                <th class="text-center">Position</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:if test="${not empty users}">
                                                <c:forEach items="${users}" var="user">
                                                    <tr>
                                                        <td class="text-center">${user.userId}</td>
                                                        <td class="text-center">${user.userName}</td>
                                                        <td class="text-center">${user.department.departmentName}</td>
                                                        <td class="text-center">${user.title.titleName}</td>
                                                        <td class="text-center">${user.position.positionName}</td>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </jsp:body>
</t:wrapper>