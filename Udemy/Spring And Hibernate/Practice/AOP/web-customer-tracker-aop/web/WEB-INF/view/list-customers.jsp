<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>List Customers</title>

    <!-- pageContext.request.contextPath gives app name -->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
<br><br>
</div>

<div id="container">

    <div id="content">

        <form:form action="searchCustomer" modelAttribute="customerToSearch" method="POST">
            <table>
                <tbody>
                <tr>
                    <td><label>First Name:</label></td>
                    <td><form:input path="firstName" /></td>
                </tr>
                <tr>
                    <td><label>Last Name:</label></td>
                    <td><form:input path="lastName" /></td>
                </tr>
                <tr>
                    <td><label>Email:</label></td>
                    <td><form:input path="email" /></td>
                </tr>

                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Search" class="save" /></td>
                </tr>
                </tbody>
            </table>
        </form:form>

        <!-- Add button: Add Customer -->
        <input type="button" value="Add Customer"
               onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"
               />


        <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="tempCustomer" items="${customers}">

                    <!-- construct an update link with customer id -->
                    <c:url var="updateLink" value="/customer/showFormForUpdate" >
                        <c:param name="customerId" value="${tempCustomer.id}" />
                    </c:url>

                    <c:url var="deleteLink" value="/customer/delete" >
                        <c:param name="customerId" value="${tempCustomer.id}" />
                    </c:url>

                    <tr>
                        <td>${tempCustomer.firstName}</td>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.email}</td>
                        <td>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                                onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false;">
                                Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>

        </table>

    </div>
</div>

</body>

</html>