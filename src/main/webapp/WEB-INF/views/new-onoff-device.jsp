<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tomek
  Date: 26.11.18
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>onoff</title>
</head>
<body>

<form:form modelAttribute="newDevice" method="post" action="/addnew/${typeNumber}">
    name<form:input path="name" />
    pin<form:input path="pin_number" />
    <input type="submit" value="wyslij">
</form:form>

</body>
</html>
