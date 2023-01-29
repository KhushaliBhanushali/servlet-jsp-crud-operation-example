<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Employee Edit</title>
</head>
<body>
	<div class="container my-3 col-md-6">
		<h1>Employee Edit</h1>
		<a href="employee_list.jsp">Return to Employee List</a>
		<form method="post" action="update">
			<input type="text" class="form-control" id="id" name="id"
				value="<c:out value='${employee.id}' />">
			<div class="form-group">
				<label for="name">Name</label> <input type="text"
					class="form-control" id="name" name="name"
					value="<c:out value='${employee.name}' />"
				placeholder="Enter employee name">
			</div>
			<div class="form-group">
				<label for="department">Department</label> <input type="text"
					class="form-control" id="department" name="department"
					value="<c:out value='${employee.department}' />"
				placeholder="Enter employee department">
			</div>
			<div class="form-group">
				<label for="email">Email</label> <input type="email"
					class="form-control" id="email" name="email"
					value="<c:out value='${employee.email}' />"
				placeholder="Enter employee email">
			</div>
			<div class="form-group">
				<label for="city">City</label> <input type="text"
					class="form-control" id="city" name="city"
					value="<c:out value='${employee.city}' />"
				placeholder="Enter employee city">
			</div>
			<div class="form-group">
				<label for="salary">Salary</label> <input type="number"
					class="form-control" id="salary" name="salary"
					value="<c:out value='${employee.salary}' />"
				placeholder="Enter employee salary">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>