<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>About client</title>
</head>
<body>
<p><b>Login: </b>${requestScope.client.getLogin()}</p>
<p><b>Password: </b>${requestScope.client.getPassword()}</p>
<p><b>E-mail: </b>${requestScope.client.getEmail()}</p>
<p><b>Last order date: </b>${requestScope.client.getAddress()}</p>
<p><b>Role: </b>${requestScope.client.getRole()}</p>
</body>
</html>