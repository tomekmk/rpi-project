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
                    <div class="title"><strong>Wybierz typ urządzenia</strong></div>
                    <div class="block-body">
                        <form class="form-horizontal" method="post">

                            <div class="form-group row">
                                <div class="col-sm-9">

                                    <c:forEach items="${types}" var="type">
                                    <div class="i-checks">
                                        <input id="radioCustom2" type="radio" checked="" value="${type.type}" name="type" class="radio-template">
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
        </div>
    </div>
</section>


<jsp:include page="../../template/footer.jsp"/>