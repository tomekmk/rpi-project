<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../template/header.jsp"/>


<section class="no-padding-top no-padding-bottom">
    <div class="container-fluid">
        <div class="row">

            <c:forEach items="${buttons}" var="button">
                <c:choose>
                    <c:when test="${button.type == 1}">
                        <div class="col-md-3 col-sm-6 smartbutton" data-btnid="${button.id}" data-btntype="${button.type}">
                            <div class="statistic-block block">
                                <div class="progress-details d-flex align-items-end justify-content-between">
                                    <div class="title">
                                        <div class="icon"><i class="icon-user-1"></i></div>
                                        <!-- todo correct icon-->
                                        <strong>${button.name}</strong>
                                    </div>
                                    <div class="number dashtext-1"></div>
                                </div>
                            </div>
                        </div>
                    </c:when>

                    <c:when test="${button.type == 2}">
                        <div class="col-md-3 col-sm-6 smartbutton" data-btnid="${button.id}" data-btntype="${button.type}">
                            <div class="statistic-block block">
                                <div class="progress-details d-flex align-items-end justify-content-between">
                                    <div class="title">
                                        <div class="icon"><i class="icon-user-1"></i></div>
                                        <!-- todo correct icon-->
                                        <strong>${button.name}</strong>
                                    </div>
                                    <div class="number dashtext-1"></div>
                                </div>
                                <div class="progress progress-template">
                                    <div role="progressbar" style="width: 0%" aria-valuenow="0" aria-valuemin="0"
                                         aria-valuemax="100" class="progress-bar progress-bar-template dashbg-1">
                                        </div>
                                    <%--<div class="dragable" style="display: block; width: 10px; height: 10px; border: 1px solid black;"></div>--%>
                                </div>
                            </div>
                        </div>
                    </c:when>

                </c:choose>
            </c:forEach>


        </div>
    </div>
</section>

<!-- ------------------------ FUNKCJONALNOŚĆ WIADOMOŚCI UŻYTKOWNIKÓW ----------------------------- -->

<%--<section class="no-padding-bottom">--%>
<%--<div class="container-fluid">--%>
<%--<div class="row">--%>
<%--<div class="col-lg-6">--%>
<%--<div class="messages-block block">--%>
<%--<div class="title"><strong>New Messages</strong></div>--%>
<%--<div class="messages"><a href="#" class="message d-flex align-items-center">--%>
<%--<div class="profile"><img src="../../files/img/avatar-3.jpg" alt="..." class="img-fluid">--%>
<%--<div class="status online"></div>--%>
<%--</div>--%>
<%--<div class="content">   <strong class="d-block">Nadia Halsey</strong><span class="d-block">lorem ipsum dolor sit amit</span><small class="date d-block">9:30am</small></div></a><a href="#" class="message d-flex align-items-center">--%>
<%--<div class="profile"><img src="../../files/img/avatar-2.jpg" alt="..." class="img-fluid">--%>
<%--<div class="status away"></div>--%>
<%--</div>--%>
<%--<div class="content">   <strong class="d-block">Peter Ramsy</strong><span class="d-block">lorem ipsum dolor sit amit</span><small class="date d-block">7:40am</small></div></a><a href="#" class="message d-flex align-items-center">--%>
<%--<div class="profile"><img src="../../files/img/avatar-1.jpg" alt="..." class="img-fluid">--%>
<%--<div class="status busy"></div>--%>
<%--</div>--%>
<%--<div class="content">   <strong class="d-block">Sam Kaheil</strong><span class="d-block">lorem ipsum dolor sit amit</span><small class="date d-block">6:55am</small></div></a><a href="#" class="message d-flex align-items-center">--%>
<%--<div class="profile"><img src="../../files/img/avatar-5.jpg" alt="..." class="img-fluid">--%>
<%--<div class="status offline"></div>--%>
<%--</div>--%>
<%--<div class="content">   <strong class="d-block">Sara Wood</strong><span class="d-block">lorem ipsum dolor sit amit</span><small class="date d-block">10:30pm</small></div></a><a href="#" class="message d-flex align-items-center">--%>
<%--<div class="profile"><img src="../../files/img/avatar-1.jpg" alt="..." class="img-fluid">--%>
<%--<div class="status online"></div>--%>
<%--</div>--%>
<%--<div class="content">   <strong class="d-block">Nader Magdy</strong><span class="d-block">lorem ipsum dolor sit amit</span><small class="date d-block">9:47pm</small></div></a></div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</section>--%>


<jsp:include page="../../template/footer.jsp"/>