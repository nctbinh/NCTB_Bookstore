<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Book Store Login</title>
    <link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>
<c:if test="${requestScope.ERROR != null}">
    <div class="container">
        <h2 class="error-message">${requestScope.ERROR}!</h2>
    </div>
</c:if>

<div class="container login-container">
    <form action="MainController" method="post" class="login-form">

        <div class="login-box">
            <label for="username" class="login-label">Username</label>
            <input type="text" name="userID" id="username" class="login-input"/>
        </div>

        <div class="login-box">
            <label for="password" class="login-label">Password</label>
            <input type="password" name="password" id="password" class="login-input"/>
        </div>

        <div class="login-box">
            <input type="submit" value="Login" name="action" class="login-button marginleft"/>
            <input type="reset" value="Reset" class="login-button"/>
        </div>
    </form>
    <div class="center">
        Don't have account? <a href="MainController?action=register">Sign up here</a>
    </div>
</div>
</body>
</html>
