<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>

<html>

<head>
    <title>dumsky284 Home Page</title>
</head>

<body>
    <h2>Home Page 111</h2>
    <hr>
    Welcome to the home page!
    <hr>
    <!-- Display username and role -->
    <p>
        User: <security:authentication property="principal.username" />
        <br><br>
        Role(s): <security:authentication property="principal.authorities" />
    </p>

     <security:authorize access="hasRole('MANAGER')">

        <!-- Add link to point to /leaders ... this is for the managers -->
        <p>
            <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
            (Only for Managers)
        </p>
    </security:authorize>

    <security:authorize access="hasRole('ADMIN')">

        <!-- Add link to point to /systems ... this is for the admins -->
        <p>
            <a href="${pageContext.request.contextPath}/systems">Administrate systems</a>
            (Only for Administrators)
        </p>
    </security:authorize>


    <hr>

    <br><br>
    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="Logout" />
    </form:form>
</body>

</html>