<%--
  Created by IntelliJ IDEA.
  User: Valentin
  Date: 31.10.2019
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action = '${pageContext.servletContext.contextPath}/create' method = 'post'>
    Name : <input type = 'text' name = 'name'/>
    LOGIN : <input type = 'text' name = 'login'/>
    E-MAIL : <input type = 'text' name = 'email'/>
    <input type = 'submit'>
</form>
<br/>
</body>
</html>