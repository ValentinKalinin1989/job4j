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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="form-style-9">
    <c:out value="${ updateError != null ? updateError: 'Update user'}"/>
</div>

<div class="form-style-8">
<form action = '${pageContext.servletContext.contextPath}/update' method = 'post'>
    Name : <input type = 'text' name = 'name' value = '${param["name"]}'/>
    LOGIN : <input type = 'text' name = 'login' value = '${param["login"]}'/>
    E-MAIL : <input type = 'text' name = 'email' value = '${param["email"]}'/>
    PASSWORD : <input type = 'text' name = 'password' value = '${param["password"]}'/>
    ROLE :
    <select name="role" >
        <option value="User">User</option>
        <option value="Admin">Admin</option>
    </select>
    COUNTRY :
    <select class="selectCountr" name="country" >
        <option value="${param["country"]}" selected> ${param["country"]} </option>
        <c:forEach items="${countries}" var="cntry">
            <option value="${cntry}"> ${cntry} </option>
        </c:forEach>
    </select>
    TOWN :
    <select id="selectTown" name="town">
        <option value="${param["town"]}" selected> ${param["town"]} </option>

    </select>
    <script>
        $(".selectCountr").change(function () {
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
    <input type = 'hidden' name = 'id' value = '${param["id"]}'>
    <input type = 'submit' value = 'SAVE'>
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
