<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>All spareparts</title>
</head>
<body>
<form id="form" action="${pageContext.request.contextPath}/spareparts-filter" method="post">
    <table>
        <caption><b>Filters</b></caption>
        <col width="200"><col width="200"><col width="200">
        <tr>
            <td>
                <input type="checkbox" name="filters" value="price"><b>Price lower than</b>
                <input type="text" name="price">
            </td>
            <td>
                <input type="checkbox" name="filters" value="country"><b>Country</b>
                <select name="country">
                    <c:forEach var="country" items="${requestScope.countries}">
                        <option value="country">${country.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <input type="checkbox" name="filters" value="sparepart_name"><b>Sparepart name from</b>
                <input type="text" name="sparepart_name">
            </td>
        </tr>
    </table>
    <br>
    <label>Show on the page
        <input type="text" name="items_on_page" size="5">
    </label><br>
    <input type="submit" value="Apply">
</form>

<table width="1200" border="1">
    <col width="200"><col width="900"><col width="50">
    <tr>
        <th align="left">Name</th>
        <th align="left">Country</th>
        <th align="left">Price</th>
        <th align="left">Sparepart name</th>
    </tr>
    <c:if test="${not empty requestScope.spareparts}">
        <c:forEach var="game" items="${requestScope.spareparts}">
            <tr>
                <td>${sparepart.name}</td>
                <td>${sparepart.country}</td>
                <td>${sparepart.price}</td>
                <td>${sparepart.name}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>