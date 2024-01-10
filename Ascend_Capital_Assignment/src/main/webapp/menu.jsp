<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Menu Items</title>
</head>
<body>
    <h2>Menu Items</h2>
    <ul>
        <c:forEach var="menuItem" items="${menuItems}">
            <li>${menuItem.itemName}
                <form action="${pageContext.request.contextPath}/drop-item" method="post">
                    <input type="hidden" name="menuItemId" value="${menuItem.id}" />
                    <button type="submit">Drop Item</button>
                </form>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
