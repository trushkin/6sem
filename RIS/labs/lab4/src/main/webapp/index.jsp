<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action="addAndShowMessage" method="post">
    <p>Enter message to add:</p>
    <label>
        <input type="text" name="messageToAdd">
    </label>
    <button type="submit" value="send">Send</button>
</form>
<form action="deleteMessage" method="post">
    <p>Enter message to delete:</p>
    <label>
        <input type="text" name="messageToDelete">
    </label>
    <button type="submit" value="send">Send</button>
</form>
<p>Messages:</p>
<c:forEach var="message" items="${messages}">
    <p>${message}</p>
</c:forEach>
</body>
</html>
