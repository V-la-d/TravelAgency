<%--
  Created by IntelliJ IDEA.
  User: vladp
  Date: 30.11.2020
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>


<html>
<head>
    <title>All hotels room</title>
</head>
<body>
<div>
            <div>
                <h2>All Rooms</h2>
                <table>
                    <thead>
                    <tr>
                        <th>Room number</th>
                        <th>Capacity</th>
                        <th>Room price</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="room" items="${roomList}">
                        <tr>
                            <td align="center" >${room.roomNumber}</td>
                            <td align="center">${room.capacity}</td>
                            <td align="center">${room.roomPrice}</td>
                            <td><a href="/update-room${room.id}">Edit</a></td>
                            <td><a href="/delete-room${room.id}">Delete</a></td>
                        </tr>
                        <c:set var="hotelId" value="${room.hotel.id}"/>
                    </c:forEach>
                    <tr>
                        <td align="center" ><a href="/add-room${hotelId}">Add room</a></td>
                    </tr>
                    </tbody>

                </table>
            </div>

</div>
</body>
</html>
