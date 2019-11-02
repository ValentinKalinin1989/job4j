<%@ page import="model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Valentin
  Date: 31.10.2019
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>

    <c:forEach items="${usersFromServer}" var="user">
        <tr>
            <th>
                <form action = '${pageContext.servletContext.contextPath}/update'  method = "get">
            <th> Name : </th> <th> <c:out value="${user.name}"></c:out>  <input type = 'hidden' name = 'name' value = <c:out value="${user.name}"></c:out>> </th>
            <th> LOGIN :</th> <th> <c:out value="${user.login}"></c:out>  <input type = 'hidden' name = 'login' value = <c:out value="${user.login}"></c:out>> </th>
            <th> E-MAIL :</th> <th> <c:out value="${user.email}"></c:out>  <input type = 'hidden' name = 'email' value = <c:out value="${user.email}"></c:out>> </th>
            <th>
                <input type = 'hidden' name = 'id' value = '<c:out value="${user.id}"></c:out>'>
                <input type = 'submit' value = 'UPDATE'>
            </th>
            </form>
            </th>

            <th>
                <form action = "${pageContext.servletContext.contextPath}/" method = "post">
            <th>
                <input type = 'hidden' name = 'id' value = '<c:out value="${user.id}"></c:out>'>
                <input type = 'submit' value = 'DELETE'>
            </th>
            </form>
            </th>
        </tr>
    </c:forEach>

</table>

</body>
</html>