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

<table class="blueTable">
    <tr>
        <th>
            <form action='${pageContext.servletContext.contextPath}/update' method="get">
        <th> Name : ${user.name} <input type='hidden' name='name' value=  ${user.name}></th>
        <th> LOGIN : ${user.login} <input type='hidden' name='login' value=  ${user.login}></th>
        <th> E-MAIL : ${user.email} <input type='hidden' name='email' value=  ${user.email}></th>
        <th> PASSWORD : ${user.password} <input type='hidden' name='password' value=  ${user.password}></th>
        <th>
            <input type='hidden' name='id' value='${user.id}'>
            <input type='submit' value='UPDATE' style="background-color: #1C6EA4">
        </th>
        </form>
        </th>
    </tr>
</table>

<div>
    <form action="${pageContext.servletContext.contextPath}/logout" method="get">
        <input type="submit" value="LOGOUT" style="background-color: #aa5522">
    </form>
</div>

</body>
</html>