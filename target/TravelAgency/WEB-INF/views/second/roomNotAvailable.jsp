<%--
  Created by IntelliJ IDEA.
  User: vladp
  Date: 02.12.2020
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Not available</title>
</head>
<body>
<h>The room not available!</h>
<form action="${contextPath}/all-hotel-rooms${hotelId}" method="post">
    <h>Check other room</h>
    <input type="submit" value="Go">
</form>
</body>
</html>
