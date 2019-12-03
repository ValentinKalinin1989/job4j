<%--
  Created by IntelliJ IDEA.
  User: Valentin
  Date: 31.10.2019
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/css/styles.css"%></style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>
<div class="form-style-9">
    <c:out value="${ createError != null ? createError: 'Create user'}"/>
</div>
<div class="form-style-8">
    <form action = '${pageContext.servletContext.contextPath}/create' method = 'post'>
        Name : <input type = 'text' name = 'name'/>
        LOGIN : <input type = 'text' name = 'login'/>
        E-MAIL : <input type = 'text' name = 'email'/>
        PASSWORD : <input type = 'text' name = 'password'/>
        ROLE :
        <select class="role" name="role" >
            <option value="User">User</option>
            <option value="Admin">Admin</option>
        </select>

        COUNTRY :
        <select class="country" name="country">
            <c:forEach items="${countries}" var="country">
                <option value="${country}"> ${country} </option>
            </c:forEach>
        </select>

        TOWN :
        <select id="selectTown" name="town">
        </select>
        <script>
            $(".country").change(function () {
                var selectedCountry = $(this).val();
                $.ajax({
                    type: 'POST',
                    url: '${pageContext.servletContext.contextPath}/town',
                    data: 'contry=' + selectedCountry,
                    dataType: 'json',
                    success: function(data) {
                        var listItems = "";
                        $.each(data, function (key, value) {
                            listItems += "<option value='" + value + "'>" + value + "</option>";
                        })
                        $("#selectTown").html(listItems);
                    }
                });
            })
        </script>
        <input type = 'submit'>
    </form>
</div>
<br/>

<div class="form-style-8">
    <form action="${pageContext.servletContext.contextPath}/logout" method="get">
        <input type="submit" value="LOGOUT">
    </form>
</div>

</body>
</html>