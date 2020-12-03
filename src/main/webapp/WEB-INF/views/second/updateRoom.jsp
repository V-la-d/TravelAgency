<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: vladp
  Date: 01.12.2020
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Update room</title>
</head>
<body>
<h2>Update room</h2>
<form:form action="${contextPath}/update-room" modelAttribute="room" method="post">
    <p>
        <form:hidden path="id"/>
    </p>
    <label for="roomNumber">Room number</label>
    <form:input path="roomNumber" type="number" id="roomNumber" placeholder="Room number"/>
    <p>
        <label for="capacity">Capacity</label>
        <form:input path="capacity" type="number" id="capacity" placeholder="Capacity"/>
    </p>
    <p>
        <label for="roomPrice">Room price</label>
        <form:input path="roomPrice" type="text" id="roomPrice" placeholder="Room price"/>
    </p>
    <p>
        <form:hidden path="hotel.id"/>
    </p>
    <p>
        <input type="submit" value="Update room">
    </p>
</form:form>
</body>
</html>
