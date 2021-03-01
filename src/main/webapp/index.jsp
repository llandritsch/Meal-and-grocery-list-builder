<html>
<body>
<h2>Meal Builder</h2>
<h3>Users</h3>

<c:choose>
    <c:when test="${users.size() > 0}">
        <table>
            <tr>
                <th>Username</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${users.getAllUsers()}</td>
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
