<%--
  Created by IntelliJ IDEA.
  User: Valentin
  Date: 31.10.2019
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <style><%@include file="/css/styles.css"%></style>
</head>
<body>
    <form action = '${pageContext.servletContext.contextPath}/update' method = 'post'>
        Name : <input type = 'text' name = 'name' value = '${param["name"]}'/>
        LOGIN : <input type = 'text' name = 'login' value = '${param["login"]}'/>
        E-MAIL : <input type = 'text' name = 'email' value = '${param["email"]}'/>
        PASSWORD : <input type = 'text' name = 'password' value = '${param["password"]}'/>
        <input type = 'hidden' name = 'role' value= 'User'>
        <input type = 'hidden' name = 'id' value = '${param["id"]}'>
        <input type = 'submit' value = 'SAVE'>
    </form>
<br/>

<div class="form-style-8">
    <form action="${pageContext.servletContext.contextPath}/logout" method="get">
        <input type="submit" value="LOGOUT">
    </form>
</div>

</body>
</html>

