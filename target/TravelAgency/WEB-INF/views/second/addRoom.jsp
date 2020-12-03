<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: vladp
  Date: 01.12.2020
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Add room</title>
</head>
<body>
<h2>Add room</h2>
<form:form action="${contextPath}/add-room" modelAttribute="room" method="post">
    <label for="roomnumber">Room number</label>
    <form:input path="roomNumber" type="number" id="roomnumber" placeholder="Room number"/>
    <p>
        <label for="capacity">Capacity</label>
        <form:input path="capacity" type="number" id="capacity" placeholder="Capacity"/>
    </p>
    <p>
        <label for="roomprice">Room price</label>
        <form:input path="roomPrice" type="text" id="roomprice" placeholder="Room price"/>
    </p>
    <p>
        <form:hidden path="hotel.id"/>
    </p>
    <p>
        <input type="submit" value="Add room">
    </p>
</form:form>
</body>
</html>
