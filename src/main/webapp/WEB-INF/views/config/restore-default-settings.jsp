<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../template/header.jsp"/>

<section class="no-padding-top">
    <div class="container-fluid">
        <div class="row">

            <div class="col-lg-6">
                <div class="block">
                    <div class="title"><strong class="d-block">
                        <a href="${pageContext.request.contextPath}/config/restore/yes">Czy jesteś pewien, że chcesz usunąć bieżące ustawienia?</a>
                    </strong></div>
                </div>
            </div>

            <div class="col-md-3 col-sm-6 smartbutton">
                <div class="statistic-block block">
                    <div class="progress-details d-flex align-items-end justify-content-between">
                        <div class="title">
                            <div class="icon"><i class="icon-user-1"><strong>

                                <a href="${pageContext.request.contextPath}/config/restore/yes">
                                    Tak, chcę to zrobić</a>

                            </strong></i>
                            </div>
                            <strong><span class="updated"></span></strong>
                        </div>
                        <div class="number dashtext-1"></div>
                    </div>
                </div>
            </div>

            <div class="col-md-3 col-sm-6 smartbutton" data-btnid="${button.id}"
                 data-btntype="${button.type}">
                <div class="statistic-block block">
                    <div class="progress-details d-flex align-items-end justify-content-between">
                        <div class="title">
                            <div class="icon"><i class="icon-user-1"><strong>

                                <a href="${pageContext.request.contextPath}/config">
                                    Nie, zachowaj ustawienia</a>

                            </strong></i>
                            </div>
                            <strong><span class="updated"></span></strong>

                        </div>
                        <div class="number dashtext-1"></div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</section>


<jsp:include page="../../template/footer.jsp"/>