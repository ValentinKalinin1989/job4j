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
    <style>
        <%@include file="/css/tableStyle.css"%>
    </style>
</head>
<body>

<div class="container">
    <table class="blueTable">
        <c:forEach items="${usersFromServer}" var="user">
            <tr>
                <th>
                    <form action='${pageContext.servletContext.contextPath}/update' method="get">
                <th> Name : ${user.name} <input type='hidden' name='name' value="${user.name}"></th>
                <th> LOGIN : ${user.login} <input type='hidden' name='login' value="${user.login}"></th>
                <th> E-MAIL : ${user.email} <input type='hidden' name='email' value="${user.email}"></th>
                <th> PASSWORD : ${user.password} <input type='hidden' name='password' value="${user.password}"></th>
                <th> ROLE : ${user.role} <input type='hidden' name='role' value="${user.role}"></th>
                <th> COUNTRY : ${user.country} <input type='hidden' name='country' value="${user.country}"></th>
                <th> TOWN : ${user.town} <input type='hidden' name='town' value="${user.town}"></th>
                <th>
                    <input type='hidden' name='id' value='${user.id}'>
                    <input type='submit' value='UPDATE' style="background-color: #2D77A2">
                </th>
                </form>
                </th>

                <th>
                    <form action="${pageContext.servletContext.contextPath}/" method="post">
                <th>
                    <input type='hidden' name='id' value='<c:out value="${user.id}"></c:out>'>
                    <input type='submit' value='DELETE' style="background-color: #aa5522">
                </th>
                </form>
                </th>
            </tr>
        </c:forEach>
    </table>
</div>
<br/>
<form action='${pageContext.servletContext.contextPath}/create' method="get">
    <input type='submit' value='CREATE' style="background-color: #228b22">
</form>
<form action="${pageContext.servletContext.contextPath}/logout" method="get">
    <input type="submit" value="LOGOUT" style="background-color: #aa5522">
</form>
</body>
</html>