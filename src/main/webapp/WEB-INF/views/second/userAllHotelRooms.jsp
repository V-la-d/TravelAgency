<%--
  Created by IntelliJ IDEA.
  User: vladp
  Date: 02.12.2020
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Available room in hotel</title>
</head>
<body>
<%--<div>
    <c:if test="${truee==true}">
        Thre</c:if>
</div>--%>
<div>
    <h2>All Rooms</h2>
    <c:if test="${truee==true}">
        We could not find any hotels by the name and country</c:if>
    <table>
        <thead>
        <tr>
            <th>Room number</th>
            <th>Capacity</th>
            <th>Room price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="room" items="${rooms}">
            <tr>
                <td align="center">${room.roomNumber}</td>
                <td align="center">${room.capacity}</td>
                <td align="center">${room.roomPrice}</td>
                <td>
                    <form action="${contextPath}/available-hotel-r${room.id}" method="post">
                        <div>
                            <label for="dateOfArrival">Date of arrival</label>
                            <input type="date" name="checkIn" id="dateOfArrival">
                            <p>
                                <label for="dateOfDeparture">Date of departure</label>
                                <input type="date" name="checkOut" id="dateOfDeparture">
                            </p>
                            <p>
                                <input type="hidden" name="hotelId" value="${room.hotel.id}">
                            </p>
                            <input type="submit" value="check the room">

                        </div>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
