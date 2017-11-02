<%--
  Created by IntelliJ IDEA.
  User: luongnv
  Date: 10/27/2017
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<section class="menu-section">
    <div class="container">
        <c:set var="req" value="${pageContext.request}" />
        <c:set var="url">${req.requestURL}</c:set>
        <c:set var="uri" value="${url.split('/')}" />
        <div class="row">
            <div class="col-md-12">
                <div class="navbar-collapse collapse ">
                    <ul id="menu-top" class="nav navbar-nav navbar-right">

                        <li
                                class="${uri[2] == '' ?'menu-top-active' : '' }"><a
                                href="${rc.getContextPath()}/">Dashboard
                        </a></li>
                        <li class="${uri[2] == '' ?'menu-top-active' : '' }"><a href="${rc.getContextPath()}/user/">USER MANAGEMENT</a></li>
                        <li><a href="${rc.getContextPath()}/department/">DEPARTMENT MANAGEMENT</a></li>
                        <li><a href="${rc.getContextPath()}/title/">TITLE MANAGEMENT</a></li>
                        <li><a href="${rc.getContextPath()}/position/">POSITION MANAGEMENT</a></li>
                        <li><a href="${rc.getContextPath()}/filter/">USER FILTER</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>