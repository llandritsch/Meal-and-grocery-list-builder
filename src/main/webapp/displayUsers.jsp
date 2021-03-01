<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${users.size() > 0}">
        <table>
            <tr>
                <th>Username</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.getUserName()}</td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <p>No users</p>
    </c:otherwise>
</c:choose>
</body>
</html>
