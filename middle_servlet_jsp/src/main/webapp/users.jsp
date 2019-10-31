<%@ page import="model.User" %>
<%@ page import="java.util.concurrent.CopyOnWriteArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<%
    CopyOnWriteArrayList<User> userArrayList = (CopyOnWriteArrayList<User>) request.getAttribute("usersFromServer");
%>
<table>
    <% for (User user: userArrayList) { %>
            <tr>
                <th>
                <form action = "<%=String.format("%s/update", request.getContextPath())%>"  method = "get">
                <th> Name : </th> <th> <%=user.getName()%>  <input type = 'hidden' name = 'name' value = <%=user.getName()%>> </th>
                <th> LOGIN :</th> <th> <%=user.getLogin()%>  <input type = 'hidden' name = 'login' value = <%=user.getLogin()%>> </th>
                <th> E-MAIL :</th> <th> <%=user.getEmail()%>  <input type = 'hidden' name = 'email' value = <%=user.getEmail()%>> </th>
                   <th>
                    <input type = 'hidden' name = 'id' value = '<%=String.valueOf(user.getId())%>'>
                    <input type = 'submit' value = 'UPDATE'>
                   </th>
                </form>
                </th>

                <th>
                <form action = "<%=String.format("%s/users", request.getContextPath())%>" method = "post">
                    <th>
                    <input type = 'hidden' name = 'id' value = '<%=String.valueOf(user.getId())%>'>
                    <input type = 'submit' value = 'DELETE'>
                    </th>
                </form>
                </th>
            </tr>
        <% } %>

</table>

</body>
</html>
