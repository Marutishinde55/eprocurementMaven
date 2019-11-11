<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
<title>User Login</title>
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
<h2>EprocureMent Admin Login</h2>
</div>
</div>

<div id="container">
<h3>Admin Login</h3>
<form:form action="AdminPage" modelAttribute="admin" method="get" >
<table>
    <tbody>
		<tr>
		<td><label>UserName</label></td>
			<td><form:input path="userName"/></td>
		</tr>
		<tr>
		<td><label>Password</label></td>
			<td><form:password path="password"/></td>
		</tr>
		<tr>
		<td><label></label></td>
			<td><input type="submit" value="Login" class="save"></td>
		</tr>
	</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/customer/forgotPassword">Forgot Password</a>
<a href="${pageContext.request.contextPath}/customer/login">HomePage</a>
</div>
</body>

</html>