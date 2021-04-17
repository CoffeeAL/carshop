<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Some spareparts</title>
</head>
<body>
<table width="1200" border="1">
    <col width="200"><col width="950"><col width="50">
    <tr>
        <th align="left">Sparepart name</th>
        <th align="left">Country</th>
        <th align="left">Price</th>
    </tr>
    <c:if test="${not empty requestScope.filteredSpareparts}">
        <c:forEach var="sparepart" items="${requestScope.filteredSpareparts}">
            <tr>
                <td>${sparepart.name}</td>
                <td>${sparepart.country}</td>
                <td>${sparepart.price}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<table cellspacing="7">
    <tr>
        <c:if test="${requestScope.pagesNumber ne 1}">
            <c:forEach begin="1" end="${requestScope.pagesNumber}" var="i">
                <c:choose>
                    <c:when test="${requestScope.currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="${pageContext.request.contextPath}/spareparts-filter?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </c:if>
    </tr>
</table>
</body>
</html>