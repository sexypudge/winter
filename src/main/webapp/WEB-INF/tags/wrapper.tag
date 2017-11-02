<%@tag description="Overall Page template" pageEncoding="UTF-8" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <![endif]-->
    <title>WINTER CURSE</title>
    <!-- BOOTSTRAP CORE STYLE  -->
  <%--  <link href="${rc.getContextPath()}/resources/css/bootstrap.css" rel="stylesheet" />--%>
    <link href="${rc.getContextPath()}/resources/css/bootstrap.min.css" rel="stylesheet" />

    <!-- FONT AWESOME ICONS  -->
    <link href="${rc.getContextPath()}/resources/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLE  -->
    <link href="${rc.getContextPath()}/resources/css/style.css" rel="stylesheet" />
    <!-- HTML5 Shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

</head>
    <body>
        <div id="pageheader">
            <jsp:invoke fragment="header" />
        </div>
        <div id="body">
            <jsp:doBody/>
        </div>
        <div id="pagefooter">
            <jsp:invoke fragment="footer"/>
        </div>
    </body>
<!-- CORE JQUERY SCRIPTS -->
<script
        src="${rc.getContextPath()}/resources/js/jquery-3.2.1.js"></script>
<!-- BOOTSTRAP SCRIPTS  -->
<script src="${rc.getContextPath()}/resources/js/bootstrap.min.js"></script>
<%--<script src="${rc.getContextPath()}/resources/js/bootstrap.js"></script>--%>
</html>
