<%--
  Created by IntelliJ IDEA.
  User: vladp
  Date: 01.12.2020
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Find by country</title>
</head>
<body>
<h2>Find hotels in the country</h2>
<form action="${contextPath}/find-h-by-c" method="post">
    <div>
        <c:if test="${falsee==false}">
            We could not find any hotels in this country</c:if>
    </div>
    <label for="writeCountyName">Country name</label>
    <input type="text" name="countryName" id="writeCountyName" placeholder="Country name">
    <input type="submit" value="Find hotels">
</form>
</body>
</html>
