<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
	<title>Customer Confirmation</title>
</head>

<body>

The customer is Confirmed: ${ customer.lastName } ${ customer.firstName }

<br><br>

Free Passes: ${customer.freePasses }

<br><br>

Postal Code: ${customer.postalCode }

<br><br>

Course Code: ${customer.courseCode }

</body>

</html>