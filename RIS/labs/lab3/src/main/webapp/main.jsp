<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>
    <style>
        <%@include file="/WEB-INF/css/customers.css" %>
    </style>
</head>
<body>
<form action="getByIdAndDelete" method="get">
    Select a Category:&nbsp;
    <select name="customerToPrint">
        <c:forEach var="customer" items="${customersToDropdown}">
            <option value="${customer.id}">${customer.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Search"/>
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
    <c:forEach var="customer" items="${customersToTable}">
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
    <p>Choose customer id to delete</p>
    <select name="customerToDelete">
        <c:forEach var="customer" items="${customersToDropdown}">
            <option value="${customer.id}">${customer.name}</option>
        </c:forEach>
    </select>
    <p class="error-message">
        <c:if test="${deleteErr != null}">${deleteErr}</c:if>
    </p>
    <input type="submit" value="Delete">
</form>
<hr>
<form action="insertAndUpdate" method="get">
    <p>Enter customer details</p>
    <p class="error-message">
        <input type="text" name="name" placeholder="Name">
        <c:if test="${insertNameErr != null}">${insertNameErr}</c:if>
    </p>
    <p class="error-message">
        <input type="text" name="surname" placeholder="Surname">
        <c:if test="${insertSurnameErr != null}">${insertSurnameErr}</c:if>
    </p>
    <p class="error-message">
        <input type="text" name="city" placeholder="City">
        <c:if test="${insertCityErr != null}">${insertCityErr}</c:if>
    </p>
    <p class="error-message">
        <input type="number" name="creditLimit" placeholder="Credit limit">
        <c:if test="${insertCreditLimitErr != null}">${insertCreditLimitErr}</c:if>
    </p>
    <p class="error-message">
        <input type="text" name="mainAddress" placeholder="Main address">
        <c:if test="${insertMainAddressErr != null}">${insertMainAddressErr}</c:if>
    </p>
    <p class="error-message">
        <input type="text" name="additionalAddress" placeholder="Additional address">
        <c:if test="${insertAdditionalAddressErr != null}">${insertAdditionalAddressErr}</c:if>
    </p>
    <input type="submit" value="Insert">
</form>
<hr>
<form action="insertAndUpdate" method="post">
    <p>Enter customer details</p>
    <select name="id">
        <c:forEach var="customer" items="${customersToDropdown}">
            <option value="${customer.id}">${customer.name}</option>
        </c:forEach>
    </select>
    <p class="error-message">
        <input type="text" name="name" placeholder="Name">
        <c:if test="${updateNameErr != null}">${updateNameErr}</c:if>
    </p>
    <p class="error-message">
        <input type="text" name="surname" placeholder="Surname">
        <c:if test="${updateSurnameErr != null}">${updateSurnameErr}</c:if>
    </p>
    <p class="error-message">
        <input type="text" name="city" placeholder="City">
        <c:if test="${updateCityErr != null}">${updateCityErr}</c:if>
    </p>
    <p class="error-message">
        <input type="number" name="creditLimit" placeholder="Credit limit">
        <c:if test="${updateCreditLimitErr != null}">${updateCreditLimitErr}</c:if>
    </p>
    <p class="error-message">
        <input type="text" name="mainAddress" placeholder="Main address">
        <c:if test="${updateMainAddressErr != null}">${updateMainAddressErr}</c:if>
    </p>
    <p class="error-message">
        <input type="text" name="additionalAddress" placeholder="Additional address">
        <c:if test="${updateAdditionalAddressErr != null}">${updateAdditionalAddressErr}</c:if>
    </p>
    <input type="submit" value="Update">
</form>
<hr>
</body>
</html>