<%--
  Created by IntelliJ IDEA.
  User: vladp
  Date: 01.12.2020
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>All hotels in country</title>
</head>
<body>
<div>
            <div>
                <h2>All Hotels</h2>
                <table>
                    <thead>
                    <tr>
                        <h>Here you can see all hotels in the country</h>
                    </tr>
                    <tr>
                        <th>Hotel name</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="hotel" items="${hotels}">
                        <tr>
                            <td>${hotel.hotelName}</td>
                            <td>
                                <form action="${contextPath}/all-hotel-rooms${hotel.id}" method="post">
                                    <input type="submit" value="check a specific room">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

</div>
</body>
</html>
