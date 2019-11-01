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
</head>
<body>

<form action = '${pageContext.servletContext.contextPath}/update' method = 'post'>
    Name : <input type = 'text' name = 'name' value = '${param["name"]}'>
    LOGIN : <input type = 'text' name = 'login' value = '${param["login"]}'>
    E-MAIL : <input type = 'text' name = 'email' value = '${param["email"]}'>
    <input type = 'hidden' name = 'id' value = '${param["id"]}'>
    <input type = 'submit' value = 'SAVE'>
    </form>
<br/>

</body>
</html>
