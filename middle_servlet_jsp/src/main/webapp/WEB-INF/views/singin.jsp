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
    <style>
        <%@include file="/css/styles.css" %>
    </style>
</head>

<body>
<div class="form-style-9">
    <c:out value="${ error != null ? error: welcome}"/>
</div>

<div class="form-style-8">
    <form action="${pageContext.servletContext.contextPath}/singin" method="post">
        LOGIN : <input type='text' name='login'/>
        <br/>
        PASSWORD : <input type='password' name='password'/>
        <input type="submit" value="SingIn">
    </form>
</div>

</body>
</html>
