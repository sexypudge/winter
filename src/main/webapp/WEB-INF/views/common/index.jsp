<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<script src="${rc.getContextPath()}/resources/js/jquery-3.2.1.js"></script>
<script src="${rc.getContextPath()}/resources/js/index.js"></script>
<t:wrapper>

    <jsp:attribute name="header">
        <%@include file="header.jsp" %>
        <%@include file="userprofile.jsp" %>
        <%@include file="menu.jsp" %>
    </jsp:attribute>

    <jsp:attribute name="footer">
        <%@include file="footer.jsp" %>
    </jsp:attribute>

    <jsp:body>

        <script id="address-template" type="text/x-handlebars-template">
            {{description.escaped}}
            {{example}}

            <br><br>

            {{description.unescaped}}
            {{{example}}}
        </script>

        <!-- The #each helper iterates over an array of items. -->
        <script id="example-template" type="text/x-handlebars-template">

            <!-- people is looked up on the global context, the one we pass to the compiled template -->

            {{#each people}}

            <!-- Here the context is each individual person. So we can access its properties directly: -->
            <p>{{firstName}} {{lastName}}</p>

            {{/each}}

        </script>

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
                            Handle Bar
                        </div>
                        <div class="content-placeholder"></div>
                    </div>
                </div>
                <div class="row" style="height: 400px;">
                </div>
            </div>
        </div>
    </jsp:body>
</t:wrapper>