<%--
  Created by IntelliJ IDEA.
  User: vladp
  Date: 01.12.2020
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Home menu</title>
</head>
<body>
<p><a href="${contextPath}/find-h-by-c">Find hotels</a></p>
<form action="${contextPath}/mainmenu" method="get">
    <button>Main menu</button>
</form>
</body>
</html>
