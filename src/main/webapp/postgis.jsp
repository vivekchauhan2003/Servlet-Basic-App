<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>postGisModel Data</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>postGisModel Data :</h1>
        </div>
        
        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Seq</th>
                        <th>Word</th>
                        <th>StdWord</th>
                        <th>Token</th>
                        <th>Is_custom</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${postGisModels}" var="postGisModel">
                        <tr>
                            <td>#${postGisModel.id}</td>
                            <td>#${postGisModel.seq}</td>
                            <td>#${postGisModel.word}</td>
                            <td>#${postGisModel.stdword}</td>
                            <td>#${postGisModel.token}</td>
                            <td>#${postGisModel.is_custom}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>