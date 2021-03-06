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
            var positionId ;

            $(document).ready(function() {
                $("#buttonDelete").click(function () {
                    if(positionId){
                        $.ajax({
                            type: "POST",
                            url: "${rc.getContextPath()}/position/delete",
                            data:{
                                positionId: positionId
                            },
                            success: function(data){
                                location.href = "${rc.getContextPath()}/position/"
                            }
                        });
                    }
                });
            });

            function getIdtoRemove(idToRemove, nameToRemove){
                positionId = idToRemove;
                $("#nameToRemove").text(nameToRemove);
                $("#myModal").modal();
            }

        </script>
        <div class="content-wrapper">

            <form>
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h4 class="page-head-line"> Position List </h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-bordered table-hover">
                                                <thead>
                                                <tr>
                                                    <th class="text-center">
                                                        <a class=" glyphicon glyphicon-plus"
                                                           href="${rc.getContextPath()}/position/addNew"></a>
                                                    </th>
                                                    <th class="text-center">#</th>
                                                    <th class="text-center">POSITION Name</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                    <c:if test="${not empty positions}">
                                                        <c:forEach items="${positions}" var="position">
                                                            <tr>
                                                                <td class="text-center">
                                                                    <a class="glyphicon glyphicon-pencil"
                                                                       href="${rc.getContextPath()}/position/showDetail?positionId=${position.positionId}"></a>
                                                                    <a class="glyphicon glyphicon-remove alert-danger" name="deleteButton"
                                                                       onclick="getIdtoRemove(${position.positionId},
                                                                               '${position.positionName}')" />
                                                                </td>
                                                                <td class="text-center">${position.positionId}</td>
                                                                <td class="text-center">${position.positionName}</td>
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

                <div id="myModal" class="modal fade" role="dialog">
                    <div class="modal-dialog">
                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Xoá?</h4>
                            </div>
                            <div class="modal-body">
                                <p>Xác Nhận Xoá <span style="color:red;" id="nameToRemove"></span>? </p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" id="buttonDelete" class="btn btn-default"> OK </button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </jsp:body>
</t:wrapper>