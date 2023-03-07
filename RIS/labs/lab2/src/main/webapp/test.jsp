<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Railway Tickets</title>
  <style>
    <%@include file="/WEB-INF/css/tickets.css" %>
  </style>
</head>
<table>
  <tr>
    <th>Id</th>
    <th>Type</th>
    <th>Train number</th>
    <th>Price</th>
    <th>Ticket class</th>
  </tr>
  <c:forEach var="railwayTicket" items="${ticketList}">
    <tr>
      <td>${railwayTicket.ticketId}</td>
      <td>${railwayTicket.ticketType}</td>
      <td>${railwayTicket.trainNum}</td>
      <td>${railwayTicket.price}</td>
      <td>${railwayTicket.ticketClass}</td>
    </tr>
  </c:forEach>
</table>
<p class="error-message">
  <c:if test="${ticketList.size() == 0}">No tickets found</c:if>
</p>
<form action="test" method="get">
  <p>Price:</p>
  <input type="number" name="price" value="${price}">
  <input type="submit" value="Filter">
  <p class="error-message">
    <c:if test="${err != null}">${err}</c:if>
  </p>
</form>
<form action="test" method="get">
  <input type="submit" value="Clear" name="clear">
</form>
<br>
<p>
  Download tickets for selected train
</p>
<form action="test" method="post">
  <input type="number" name="trainNum">
  <input type="submit" value="test">
  <p class="error-message">
    <c:if test="${postErr != null}">${postErr}</c:if>
  </p>
</form>


</html>