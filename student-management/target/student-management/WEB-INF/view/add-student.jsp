<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/student-management/URLToReachResourcesFolder/css/add-student.css">
<link rel="stylesheet" type="text/css" href="/student-management/URLToReachResourcesFolder/css/my-style-sheet.css">
</head>
<body>

<div align="center">
<h1>Add Student</h1>
	<form:form action="save-student" modelAttribute="student" method="POST">
		
		<form:hidden path="id"/>
		
		<label>Name: </label>
		<form:input path="name"/>
		<br/>
		<br/>
		
		<label>Mobile: </label>
		<form:input path="mobile"/>
		<br/>
		<br/>
		
		<label>Country: </label>
		<form:input path="country"/>
		<br/>
		<br/>
		
		<input type="submit" value="Submit" class="myButton">
		
			
	</form:form>
	
</div>
</body>
</html>