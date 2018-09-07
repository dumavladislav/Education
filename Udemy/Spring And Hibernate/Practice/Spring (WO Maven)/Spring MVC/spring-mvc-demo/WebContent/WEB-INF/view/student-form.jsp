<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
</head>

<body>

</body>

<form:form action="processForm" modelAttribute="student">
	First Name: <form:input path="firstName" />

	<br>
	<br>
	
	Last Name: <form:input path="lastName" />
	<br>
	<br>
	
	Country: 
	<form:select path="country">
		<form:options items="${theCountryOptions}" />
		
	</form:select>
	
	<br>
	<br>
	
	Favourite Language:
	<!-- 
	Java <form:radiobutton path="favouriteLanguage" value="Java" />
	C# <form:radiobutton path="favouriteLanguage" value="C#" />
	PHP <form:radiobutton path="favouriteLanguage" value="PHP" />
	Ruby <form:radiobutton path="favouriteLanguage" value="Ruby" />
	 -->
	 
	<form:radiobuttons path="favouriteLanguage" items="${ theLanguageOptions }" /> 
	
	<br>
	<br>
	
	Operating Systems:
	 
	Linux <form:checkbox path="operatingSystems" value="Linux" />
	Windows <form:checkbox path="operatingSystems" value="Windows" />
	MacOS <form:checkbox path="operatingSystems" value="MacOS" />
	
	<br><br>

	<input type="submit" value="Submit" />
</form:form>


</html>