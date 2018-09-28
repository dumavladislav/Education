<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
    <title>dumsky284 Home Page</title>
</head>

<body>
    <h2>Home Page 111</h2>
    <hr>
    Welcome to the home page!
    <br><br>
    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="Logout" />
    </form:form>
</body>

</html>