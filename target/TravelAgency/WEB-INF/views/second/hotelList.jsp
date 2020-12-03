<%--
  Created by IntelliJ IDEA.
  User: vladp
  Date: 30.11.2020
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>All hotels</title>
</head>
<body>
<div>
            <div>
                <h2>All Hotels</h2>
                <table>
                    <thead>
                    <tr>
                        <th>Hotel name</th>
                        <th>Country</th>
                        <th>Rating of hotel</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="hotel" items="${hotels}">
                        <tr>
                            <td>${hotel.hotelName}</td>
                            <td>${hotel.countryName}</td>
                            <td align="center">${hotel.hotelRating}</td>
                            <td><a href="/update-hotel${hotel.id}">Edit</a></td>
                            <td><a href="/delete-hotel${hotel.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
    <p>
        <a href="<c:url value="/add-hotel"/>">Add hotel</a>
    </p>
</div>
</body>
</html>
