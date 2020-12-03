<%--
  Created by IntelliJ IDEA.
  User: vladp
  Date: 30.11.2020
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Management page</title>
</head>
<body>
<h2>Management menu</h2>
<p><a href="${contextPath}/hotel-list">Hotel editing functions</a></p>
<p><a href="${contextPath}/find-h-by-n">Room editing functions</a></p>
<p><a href="${contextPath}/all-user-and-orders">All users and and their orders</a></p>
<form action="${contextPath}/mainmenu">
    <button>Main menu</button>
</form>
</body>
</html>
