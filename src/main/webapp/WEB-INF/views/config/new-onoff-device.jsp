<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../template/header.jsp"/>

<section class="no-padding-top">
    <div class="container-fluid">
        <div class="row">
            <!-- Form Elements -->
            <div class="col-lg-12">
                <div class="block">
                    <div class="title"><strong>Wprowadź dane urządzenia</strong></div>
                    <div class="block-body">
                        <form:form modelAttribute="newDevice" method="post" action="/config/addnew/1" class="form-horizontal">

                        <div class="form-group row">
                            <label class="col-sm-3 form-control-label">Podaj nazwę urządzenia</label>
                            <div class="col-sm-9">
                                <form:input path="name" cssClass="form-control" placeholder="nazwa urządzenia"/>
                                <small class="help-block-none"><form:errors path="name"/></small>
                            </div>
                        </div>
                        <div class="line"></div>

                        <div class="form-group row">
                            <label class="col-sm-3 form-control-label">Podaj opis urządzenia</label>
                            <div class="col-sm-9">
                                <form:input path="description" cssClass="form-control" placeholder="opis urządzenia"/>
                                <small class="help-block-none"><form:errors path="description"/></small>
                            </div>
                        </div>
                        <div class="line"></div>


                        <div class="form-group row">
                            <label class="col-sm-3 form-control-label">Wybierz pin</label>
                            <div class="col-sm-9">
                                    <form:select path="pin" items="${pinsList}" cssClass="form-control mb-3 mb-3" itemValue="pinNumber" itemLabel="pinNumber"/>
                                <small class="help-block-none"><form:errors path="pin"/></small>
                            </div>
                        </div>
                            <div class="line"></div>


                        <div class="form-group row">
                            <label class="col-sm-3 form-control-label">Wybierz lokalizację</label>
                            <div class="col-sm-9">
                                <form:select path="location" items="${locations}" cssClass="form-control mb-3 mb-3" itemValue="id" itemLabel="nameAndFloor"/>
                                <small class="help-block-none"><form:errors path="location"/></small>
                            </div>
                        </div>
                            <div class="line"></div>


                            <div class="form-group row">
                                <div class="col-sm-9 ml-auto">
                                    <button type="submit" class="btn btn-primary">Dalej</button>
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