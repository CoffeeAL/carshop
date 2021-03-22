<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Client info</title>
</head>
<body>
<p><b>Login: </b>${requestScope.client.getLogin()}</p>
<p><b>Password: </b>${requestScope.client.getPassword()}</p>
<p><b>E-mail: </b>${requestScope.client.getEmail()}</p>
<p><b>Last order date: </b>${requestScope.client.getAddress()}</p>
<p><b>Role: </b>${requestScope.client.getRole().name}</p>
<%--<c:if test="${requestScope.client.getRole() eq 'ADMIN'}">--%>
<%--    <p><b>Salary: </b>${requestScope.client.salary}</p>--%>
<%--</c:if>--%>
<%--<c:if test="${requestScope.client.getRole() eq 'USER'}">--%>
<%--    <p><b>Last Visit Date: </b>${requestScope.user.lastVisitDate}</p>--%>
<%--</c:if>--%>
</body>
</html>