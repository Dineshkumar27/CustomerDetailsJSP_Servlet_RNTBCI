<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Customer Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>WalMark </h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
			
			<input type="button" value="Add Customer" 
				   onclick="window.location.href='add-customer.jsp'; return false;"
				   class="add-Customer-button"
			/>
			
			<table>
			
				<tr>
					<th>Customer Name</th>
					<th>City</th>
					<th>isPrivileged</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempCustomer" items="${CUSTOMER_LIST}">
					
					<!-- set up a link for each Customer -->
					<c:url var="tempLink" value="CustomerControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="customername" value="${tempCustomer.customerName}" />
					</c:url>

					<!--  set up a link to delete a Customer -->
					<c:url var="deleteLink" value="CustomerControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="customername" value="${tempCustomer.customerName}" />
					</c:url>
																		
					<tr>
						<td> ${tempCustomer.customerName} </td>
						<td> ${tempCustomer.customerCity} </td>
						<td> ${tempCustomer.isPrivileged()} </td>
						<td> 
							<a href="${tempLink}">Update</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this Customer?'))) return false">
							Delete</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>
