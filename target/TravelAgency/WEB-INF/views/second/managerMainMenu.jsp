<%--
  Created by IntelliJ IDEA.
  User: vladp
  Date: 30.11.2020
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Manager main menu</title>
</head>
<body>
<div class="continer">
    <form action="${contextPath}/mainmenu" method="post">
        <h2>It's manager main menu</h2>
        <p><a href="${contextPath}/home">Home page</a></p>
        <p><a href="${contextPath}/management">Management page</a></p>

        <button type="submit">Logout</button>
    </form>
</div>
</body>
</html>
