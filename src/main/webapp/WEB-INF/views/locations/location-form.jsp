<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../template/header.jsp"/>


<section class="no-padding-top">
    <div class="container-fluid">
        <div class="row">

            <c:choose>
                <c:when test="${isAnyLocations}">
                    <div class="col-lg-6">
                        <div class="block">
                            <div class="title"><strong>Lista pomieszczeń</strong></div>
                            <div class="table-responsive">
                                <table class="table table-striped table-sm">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Nazwa</th>
                                        <th>Opis</th>
                                        <th>Piętro</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach items="${locations}" var="location" varStatus="i">
                                        <tr>
                                            <th scope="row">${i.index + 1}</th>
                                            <td>${location.name}</td>
                                            <td>${location.type}</td>
                                            <td>${location.floor}</td>
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
                            <div class="title"><strong class="d-block">Brak pomieszczeń w projekcie!</strong></div>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>

            <!-- Horizontal Form-->
            <div class="col-lg-6">
                <div class="block">
                    <div class="title"><strong class="d-block">Dodaj pomieszczenie</strong><span class="d-block">Wpisz poniżej dane pomieszczenia</span>
                    </div>
                    <div class="block-body">
                        <form:form modelAttribute="newLocation" method="post" class="form-horizontal">

                            <div class="form-group row">
                                <label class="col-sm-3 form-control-label">Podaj nazwę pomieszczenia</label>
                                <div class="col-sm-9">
                                    <form:input path="name" cssClass="form-control" placeholder="nazwa pomieszczenia"/>
                                    <small class="help-block-none"><form:errors path="name" /></small>
                                </div>
                            </div>
                            <div class="line"></div>
                            <div class="form-group row">
                                <label class="col-sm-3 form-control-label">Podaj opis pomieszczenia</label>
                                <div class="col-sm-9">
                                    <form:input path="type" cssClass="form-control" placeholder="opis pomieszczenia"/>
                                    <small class="help-block-none"><form:errors path="type" /></small>
                                </div>
                            </div>
                            <div class="line"></div>
                            <div class="form-group row">
                                <label class="col-sm-3 form-control-label">Podaj piętro</label>
                                <div class="col-sm-9">
                                    <form:input path="floor" cssClass="form-control" value="0"/>
                                    <small class="help-block-none"><form:errors path="floor" /></small>
                                </div>
                            </div>
                            <div class="line"></div>

                            <div class="form-group row">
                                <div class="col-sm-9 ml-auto">
                                    <button type="submit" class="btn btn-primary">Dodaj</button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>


        </div>
    </div>
</section>


<jsp:include page="../../template/footer.jsp"/>