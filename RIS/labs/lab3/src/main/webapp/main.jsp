<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>
    <style><%@include file="/WEB-INF/css/customers.css" %></style>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>City</th>
        <th>Credit Limit</th>
        <th>Main Address</th>
        <th>Additional Address</th>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.surname}</td>
            <td>${customer.city}</td>
            <td>${customer.creditLimit}</td>
            <td>${customer.mainAddress}</td>
            <td>${customer.additionalAddress}</td>
        </tr>
    </c:forEach>
    <form action="mainPage" method="get">
        <p>Id:</p>
        <input type="number" name="id" value="${id}">
        <input type="submit" value="Search">
        <p class="error-message">
            <c:if test="${err != null}">${err}</c:if>
        </p>
    </form>
</table>
</body>
</html>