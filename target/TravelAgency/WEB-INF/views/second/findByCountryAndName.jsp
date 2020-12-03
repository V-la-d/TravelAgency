<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: vladp
  Date: 30.11.2020
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Find hotel by country and name</title>
</head>
<body>
<h2>Find hotel by country and name</h2>
<form action="${contextPath}/find-h-by-n" method="post">
    <div>
        <c:if test="${truee==true}">
            We could not find any hotels by the name and country</c:if>
    </div>
    <label for="writeCountyName">Country name</label>
    <input type="text" name="countryName" id="writeCountyName" placeholder="Country name">
    <label for="writeHotelName">Hotel name</label>
    <input type="text" name="hotelName" id="writeHotelName" placeholder="Hotel name">
    <input type="submit" value="Find hotel">
</form>
</body>
</html>
