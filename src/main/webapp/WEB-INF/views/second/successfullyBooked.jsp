<%--
  Created by IntelliJ IDEA.
  User: vladp
  Date: 02.12.2020
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Successfully booked</title>
</head>
<body>
<h1>The room was successfully booked</h1>
<form action="${contextPath}/mainmenu" method="post">
    <button type="submit">Logout</button>
</form>
</body>
</html>
