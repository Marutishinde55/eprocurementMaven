<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
<title>User Registration</title>
<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
	
	
	<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
<div id="header">
<h2>EprocureMent </h2>
</div>
</div>

<div id="container">
<h3>Registration Form </h3>
<form:form action="saveCustomer" modelAttribute="customer"  method="post">
<form:hidden path="id"/>
<table>
    <tbody>
		<tr>
			<td><label>FirstName</label></td>
			<td><form:input path="firstName"/></td>
		</tr>
		<tr>
		<td><label>LastName</label></td>
			<td><form:input path="lastName"/></td>
		</tr>
		<tr>
		<td><label>Gender</label></td>
			<td><form:select path="gender">
			<form:option value="male" label="Male"></form:option>
			<form:option value="Female" label="Female"></form:option>
			</form:select></td>
		</tr>
		<tr>
		<td><label>UserName</label></td>
			<td><form:input path="userName"/></td>
		</tr>
		<tr>
		<td><label>Password</label></td>
			<td><form:password path="password"/></td>
		</tr>
		<tr>
		<td><label>MobileNo</label></td>
			<td><form:input path="mobileNo"/></td>
		</tr>
		<tr>
		<td><label>Email</label></td>
			<td><form:input path="email"/></td>
		</tr>
		<tr>
		<td><label></label></td>
			<td><input type="submit" value="Save" class="save"></td>
		</tr>
	</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/customer/login">Back to Login Page</a>
</div>
</body>

</html>