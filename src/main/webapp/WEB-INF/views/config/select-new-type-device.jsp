<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../template/header.jsp"/>

<section class="no-padding-top">
    <div class="container-fluid">
        <div class="row">

            <c:choose>
                <c:when test="${isAnyDevice}">
                    <div class="col-lg-6">
                        <div class="block">
                            <div class="title"><strong>Lista urządzeń</strong></div>
                            <div class="table-responsive">
                                <table class="table table-striped table-sm">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Nazwa</th>
                                        <th>Opis</th>
                                        <th>Rodzaj</th>
                                        <th>Pin</th>
                                        <th>Lokalizacja</th>
                                        <th>Opcje</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach items="${devices}" var="device" varStatus="i">
                                        <tr>
                                            <th scope="row">${i.index + 1}</th>
                                            <td>${device.name}</td>
                                            <td>${device.description}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${device.type == 1}">
                                                        on / off
                                                    </c:when>
                                                    <c:when test="${device.type == 2}">
                                                        0 - 100%
                                                    </c:when>
                                                </c:choose>
                                            </td>
                                            <td>${device.pin}</td>
                                            <td>${device.location.nameAndFloor}</td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/config/edit/${device.type}/${device.id}">edytuj </a>
                                                <a href="${pageContext.request.contextPath}/config/delete/${device.type}/${device.id}">
                                                    usuń</a>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="col-lg-6">
                        <div class="block">
                            <div class="title"><strong class="d-block">Brak urządzeń w projekcie!</strong></div>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>


            <!-- Form Elements -->
            <div class="col-lg-12">
                <div class="block">
                    <div class="title"><strong>Wybierz typ urządzenia</strong></div>
                    <div class="block-body">
                        <form class="form-horizontal" method="post">

                            <div class="form-group row">
                                <div class="col-sm-9">

                                    <c:forEach items="${types}" var="type" varStatus="i">
                                        <div class="i-checks">
                                            <input id="radioCustom2" type="radio"
                                                   <c:if test="${i.index == 0}">checked</c:if> value="${type.type}"
                                                   name="type" class="radio-template">
                                            <label for="radioCustom2">${type.name}</label>
                                        </div>
                                    </c:forEach>

                                </div>
                            </div>
                            <div class="line"></div>

                            <div class="form-group row">
                                <div class="col-sm-9 ml-auto">
                                    <button type="submit" class="btn btn-primary">Dalej</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-lg-6">
                <div class="block">
                    <div class="title"><strong class="d-block">
                        <a href="${pageContext.request.contextPath}/config/restore">Przywróć ustawienia fabryczne pinów raspberry</a>
                    </strong></div>
                </div>
            </div>

        </div>
    </div>
</section>


<jsp:include page="../../template/footer.jsp"/>