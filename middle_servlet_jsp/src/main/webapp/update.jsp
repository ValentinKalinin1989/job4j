<%--
  Created by IntelliJ IDEA.
  User: Valentin
  Date: 31.10.2019
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action = ' <%=String.format("%s/update", request.getContextPath())%>' method = 'post'>
    Name : <input type = 'text' name = 'name' value = <%=request.getParameter("name")%>>
    LOGIN : <input type = 'text' name = 'login' value = <%=request.getParameter("login")%>>
    E-MAIL : <input type = 'text' name = 'email' value = <%=request.getParameter("email")%>>
    <input type = 'hidden' name = 'id' value = '<%=String.valueOf(request.getParameter("id"))%>'>
    <input type = 'submit' value = 'SAVE'>
    </form>
<br/>

</body>
</html>
