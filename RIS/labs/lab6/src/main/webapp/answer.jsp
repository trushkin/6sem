<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>BankAccounts</title>
</head>
<body>
<c:set var="animals" value="${requestScope.animals}"/>
<c:set var="message" value="${requestScope.message}"/>
<c:set var="badMessage" value="${requestScope.badMessage}"/>

<c:if test="${animals!=null && animals.size()!=0}">
    <h2>${message}</h2>
    <table border="5">
        <tr>
            <td>Animal name</td>
            <td>Feed</td>
            <td>Quantity</td>
        </tr>
        <c:forEach items="${animals}" var="animal">
            <tr>
                <td>${animal.name}</td>
                <td>${animal.feed}</td>
                <td>${animal.quantity}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${animals==null || animals.size()==0}">
    <h2>${badMessage}</h2>
</c:if>
<br><br>
<form action="index.jsp">
    <input type="submit" value="BACK">
</form>
</body>
</html>
