<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <h2>Welcome to the Dashboard!</h2>

    <h3>Announcements</h3>
    <ul>
        <c:forEach items="${announcement}" var="announcement">
            <li>${announcement.message}</li>
        </c:forEach>
    </ul>

    <hr>

    <h3>Send Announcement</h3>
    <form action="/announcement" method="post">
        <textarea name="announcement" rows="4" cols="50"></textarea><br>
        <input type="submit" value="Send">
    </form>
</body>
</html>
