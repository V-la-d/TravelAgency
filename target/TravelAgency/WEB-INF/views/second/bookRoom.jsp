<%--
  Created by IntelliJ IDEA.
  User: vladp
  Date: 02.12.2020
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Book room</title>
</head>
<body>
<h2>
    The room is available book now!
</h2>
<p>
<form action="${contextPath}/booking-room" method="post">
    <input type="submit" value="book">
</form>
</body>
</html>
