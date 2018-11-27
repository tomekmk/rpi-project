<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../template/header.jsp"/>

<!--
private Integer type;

private Integer status;

@ManyToOne
private Location location;
-->

<section class="no-padding-top">
    <div class="container-fluid">
        <div class="row">
            <!-- Form Elements -->
            <div class="col-lg-12">
                <div class="block">
                    <div class="title"><strong>Wprowadź dane urządzenia</strong></div>
                    <div class="block-body">
                        <form:form modelAttribute="newDevice" method="post" action="/config/addnew/${typeNumber}" class="form-horizontal">

                            <div class="form-group row">
                            <label class="col-sm-3 form-control-label">Podaj nazwę urządzenia</label>
                            <div class="col-sm-9">
                                <form:input path="name" cssClass="form-control" placeholder="nazwa urządzenia" />
                            </div>
                            </div>
                            <div class="line"></div>

                            <div class="form-group row">
                            <label class="col-sm-3 form-control-label">Podaj opis urządzenia</label>
                            <div class="col-sm-9">
                                <form:input path="description" cssClass="form-control" placeholder="opis urządzenia" />
                            </div>
                            </div>
                            <div class="line"></div>


                            <c:forEach items="${pinsList}" var="pin">
                                <div class="i-checks">
                                    <input id="radioCustom2" type="radio" checked="" value="${pin.pinNumber}" name="pin" class="radio-template">
                                    <label for="radioCustom2">${pin.pinNumber}</label>
                                </div>
                            </c:forEach>



                            <%--<div class="form-group row">--%>
                            <%--<label class="col-sm-3 form-control-label">Podaj numer pinu raspberry</label>--%>
                            <%--<div class="col-sm-9">--%>
                                <%--<form:input path="pin" cssClass="form-control" placeholder="np. 13" />--%>
                                <%--<small class="help-block-none"><form:errors path="pin" /></small>--%>
                            <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="line"></div>--%>




                            <!--<div class="form-group row">
                        <label class="col-sm-3 form-control-label">Help text</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control"><small class="help-block-none">A block of help text that breaks onto a new line and may extend beyond one line.</small>
                             </div>
                        </div>

                      <div class="form-group row">
                        <label class="col-sm-3 form-control-label">Placeholder</label>
                        <div class="col-sm-9">
                          <input type="text" placeholder="placeholder" class="form-control">
                        </div>
                      </div> -->

                            <%--<div class="form-group row">--%>
                                <%--<div class="col-sm-9">--%>
                            <%--<c:forEach items="${locations}" var="location">--%>
                                <%--<div class="i-checks">--%>
                                    <%--<input id="radioCustom2" type="radio" checked="" value="${type.type}" name="type" class="radio-template">--%>
                                    <%--<label for="radioCustom2">${type.name}</label>--%>
                                <%--</div>--%>
                            <%--</c:forEach>--%>
                                <%--</div>--%>
                            <%--</div>--%>


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