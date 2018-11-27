<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dodaj urządzenie</title>
</head>
<body>

<form method="post">
    <c:forEach items="${deviceType}" var="type">
        <input type="radio" name="type" value="${type}">
    </c:forEach>
    <input type="submit" value="wyślij">
</form>

</body>
</html>

<!--
private Long id;

private String name;

@Column(columnDefinition = "TEXT", length = 100)
private String description;

private Integer type;

private Integer status;

@ManyToOne
private Location location;

private Integer config_id;
-->