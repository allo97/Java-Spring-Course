<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
<title>Student registration form</title>

</head>

<body>

	<form:form action = "processForm" modelAttribute="student">
		
		First Name: <form:input path = "firstName" />
		
		<br><br>
		
		Last Name: <form:input path = "lastName" />
		
		<br><br>
		
		Country:
		
		<form:select path = "country"> 
			
			<form:options items = "${theCountryOptions}" />  <!--there we will call student.getCountryOptions() --> 
	
		</form:select>
		
		<br><br>
		
		FavoriteLanguage:
		
			<form:radiobuttons path = "favoriteLanguage" items = "${student.favoriteLanguageOptions}" />
		
		<br><br>
		
		Operating systems:
		
		Linux <form:checkbox path = "operatingSystems" value = "Linux" />
		Mac OS <form:checkbox path = "operatingSystems" value = "Mac OS" />
		MS Windows <form:checkbox path = "operatingSystems" value = "MS Windows" />
		
		<br><br>
		
		<input type="submit" value = "Submit" />
		
	</form:form>
	
	
	

</body>
</html>
