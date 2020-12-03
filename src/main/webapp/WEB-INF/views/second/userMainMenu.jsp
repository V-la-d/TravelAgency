<%--
  Created by IntelliJ IDEA.
  User: vladp
  Date: 01.12.2020
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>User main menu</title>
</head>
<body>
<div class="continer">
    <form action="${contextPath}/mainmenu" method="post">
        <h2>It's user main menu</h2>
        <p><a href="${contextPath}/home">Home page</a></p>
        <button type="submit">Logout</button>
    </form>
</div>
</body>
</html>
