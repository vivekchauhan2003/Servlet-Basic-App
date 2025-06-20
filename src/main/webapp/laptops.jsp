<!-- laptops.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Laptop List</title>
</head>
<body>
    <h1>Laptop List</h1>
    <table border="1">
        <tr>
            <th>LID</th>
            <th>Brand</th>
            <th>Model</th>
        </tr>
        <c:forEach items="${laptops}" var="laptop">
            <tr>
                <td>${laptop.lid}</td>
                <td>${laptop.brand}</td>
                <td>${laptop.model}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>