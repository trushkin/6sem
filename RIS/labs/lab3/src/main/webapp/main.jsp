<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>
    <style><%@include file="/WEB-INF/css/customers.css" %></style>
</head>
<body>
<form action="getByIdAndDelete" method="get">
    <input type="number" name="id" value="${id}" placeholder="Id">
    <input type="submit" value="Search">
    <p class="error-message">
        <c:if test="${getByIdErr != null}">${getByIdErr}</c:if>
    </p>
</form>
<form action="getByIdAndDelete" method="get">
    <input type="submit" value="Clear" name="clear">
</form>
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
</table>
<hr>
<form action="getByIdAndDelete" method="post">
    <p>Enter customer id to delete</p>
    <input type="number" name="id" placeholder="Id">
    <input type="submit" value="Delete">
    <p class="error-message">
        <c:if test="${deleteErr != null}">${deleteErr}</c:if>
    </p>
</form>
<hr>
<form action="insertAndUpdate" method="get">
    <p>Enter customer details</p>
    <input type="text" name="name" placeholder="Name">
    <input type="text" name="surname" placeholder="Surname">
    <input type="text" name="city" placeholder="City">
    <input type="number" name="creditLimit" placeholder="Credit limit">
    <input type="text" name="mainAddress" placeholder="Main address">
    <input type="text" name="additionalAddress" placeholder="Additional address">
    <input type="submit" value="Insert">
    <p class="error-message">
        <c:if test="${insertErr != null}">${insertErr}</c:if>
    </p>
</form>
<hr>
<form action="insertAndUpdate" method="post">
    <p>Enter customer details</p>
    <input type="number" name="id" placeholder="Id">
    <input type="text" name="name" placeholder="Name">
    <input type="text" name="surname" placeholder="Surname">
    <input type="text" name="city" placeholder="City">
    <input type="number" name="creditLimit" placeholder="Credit limit">
    <input type="text" name="mainAddress" placeholder="Main address">
    <input type="text" name="additionalAddress" placeholder="Additional address">
    <input type="submit" value="Update">
    <p class="error-message">
        <c:if test="${updateErr != null}">${updateErr}</c:if>
    </p>
</form>
<hr>
</body>
</html>