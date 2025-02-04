<!DOCTYPE html>
<html>

<head>
	<title>Update Customer</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-Customer-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>WalMark</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Update Customer</h3>
		
		<form action="CustomerControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="CustomerName" value="${THE_Customer.customerName}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Customer Name:</label></td>
						<td><input type="text" name="customername" 
								   value="${THE_CUSTOMER.customerName}" /></td>
					</tr>

					<tr>
						<td><label>City:</label></td>
						<td><input type="text" name="customercity" 
								   value="${THE_CUSTOMER.customerCity}" /></td>
					</tr>

					<tr>
						<td><label>isPrivileged:</label></td>
						<td><input type="text" name="isPrivileged" 
								   value="${THE_CUSTOMER.isPrivileged()}" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="CustomerControllerServlet">Back to List</a>
		</p>
	</div>
</body>

</html>











