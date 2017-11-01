<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <jsp:attribute name="header">
        <%@include file="header.jsp" %>
        <%@include file="userprofile.jsp" %>
        <%@include file="menu.jsp" %>
    </jsp:attribute>

    <jsp:attribute name="footer">
        <%@include file="footer.jsp"%>
    </jsp:attribute>

    <jsp:body>
        <div class="content-wrapper">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h4 class="page-head-line">Dashboard</h4>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="alert alert-success">
                            This is a simple admin template that can be used for your small project or may be large projects. This is free for personal and commercial use.
                        </div>
                    </div>
                </div>
                <div class="row" style="height: 400px;">
                </div>
            </div>
        </div>
    </jsp:body>
</t:wrapper>