<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
	<title>Student Confirmation</title>
</head>

<body>

The student is Confirmed: ${ student.lastName } ${ student.firstName } from ${student.country }
<br><br>
Favourite Language:	${student.favouriteLanguage }

<br><br>

<!-- IN ORDER TO MAKE LOOPING AVAILABLE - taglib string above added -->
Operating Systems:

<ul>
	<c:forEach var="temp" items="${student.operatingSystems}">
		<li>${temp }</li>
	</c:forEach>
	
</ul>

</body>

</html>