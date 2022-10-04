<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action = "hello-servlet" method = "GET">
    First Name: <input type = "text" name = "textSpart">
    <br />
    Size: <input type = "text" name = "sizeul">
    <input type = "submit" value = "Submit" />
</form>
</body>
</html>