<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Roll Number Generated</title>
</head>
<body>
    <h1>registration is successful:</h1>
    <p>roll number is:-</p>
    <p><%= request.getAttribute("rollNumber") %></p>
</body>
</html>
