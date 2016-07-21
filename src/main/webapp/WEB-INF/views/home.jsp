<%--
  Created by IntelliJ IDEA.
  User: roure
  Date: 19/07/2016
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<html>
<head>
    <title>InitMVC</title>
    <link rel="stylesheet"
        type="text/css"
        href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>Welcome to InitMVC</h1>

<a href="<c:url value="/spittles" />" >Spittles</a>
<a href="<c:url value="/spitter/register" />" >Register</a>
</body>
</html>
