<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
 
<html>
<head>
<title>List Customers</title>
<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">



</head>
<body>
<div id="wrapper">
<div id="header">
<h2>Registered Users List</h2>
</div>
</div>
<a href="${pageContext.request.contextPath}/customer/Admin">LogOut</a>
<div id="container">
<div id="content">
<table>
<tr>
<th>FIrst NAme</th>
<th>LastName</th>
<th>Gender</th>
<th>MobileNo</th>
<th>EMail</th>

<th>Action</th>
</tr>
<c:forEach var="tempCustomer" items="${customers}">
<c:url var="updateLink" value="/customer/showformforupdate">
<c:param name="customerID" value="${tempCustomer.id}"></c:param>
</c:url>
<c:url var="deleteLink" value="/customer/delete">
<c:param name="customerID" value="${tempCustomer.id}"></c:param>
</c:url>
<tr>
<td>${tempCustomer.firstName}</td>
<td>${tempCustomer.lastName}</td>
<td>${tempCustomer.gender}</td>
<td>${tempCustomer.mobileNo}</td>
<td>${tempCustomer.email}</td>
<td><a href="${updateLink}">update</a>
|<a href="${deleteLink}"
onclick="if(!(confirm('are you sure you want to delete customer?')))return false">Delete</a>
</td>

</tr>
</c:forEach>

</table>
</div>
</div>
</body>
</html>