<%--
  Created by IntelliJ IDEA.
  User: Valentin
  Date: 06.11.2019
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test = "${ error != ''}">
    <div style = "background-color: crimson">
        <c:out value ="${error}"/>
    </div>
</c:if>

<form action="${pageContext.servletContext.contextPath}/singin" method = "post">
    LOGIN : <input type = 'text' name = 'login'/>
    PASSWORD : <input type = 'password' name = 'password'/>
    <input type="submit" value = "SingIn">
</form>
</body>
</html>
