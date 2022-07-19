<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/student-management/URLToReachResourcesFolder/css/my-style-sheet.css">

</head>
<body>
 <div class="container">

	<h1 align="center">JAVA PROJECT</h1>
 	<!--<i>Student data is coming soon...</i>  -->
 	<!-- Model Attribute : students -->
 	
 
 	<form action="/student-management/showAddStudentPage">
 			<input type="submit" value="ADD Student" class="btn btn-outline-success">
 	</form>
 		<form action="/student-management/showStudent">
 			<input type="submit" value="View Student" class="btn btn-outline-success">
 		</form>
 	
 	<br />
 	
 	<table border="1" class="table table-success table-striped">
 	<thead>
 	<tr>
    <td>Id</td>
    <td>Name</td>
    <td>Mobile</td>
    <td>Country</td>
  </tr>
 	</thead>
 	
 	
 	<c:forEach var= "student" items="${students}">
 	<tr>
 	
 	 	<td> ${student.id} </td>
 	 	<td> ${student.name} </td>
 	 	<td> ${student.mobile} </td>
 	 	<td> ${student.country} </td>
 	 	<td><a href="/student-management/updateStudent?userId=${student.id}" >Update</a> </td>
 	 	<td><a href="/student-management/deleteStudent?userId=${student.id}" onclick="if(!(confirm('Are you sure you want to delete this student?'))) return false;">Delete</a> </td>
 	 	
 	</tr>
 	</c:forEach> 
 	
 	</table>
 	<br/>
 	<img alt="student group" src="/student-management/URLToReachResourcesImagesFolder/students.jpg"/>
 	</div>	
</body>
</html>