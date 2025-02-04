<%@ page import="java.util.List,java.util.ArrayList,com.jsptraining.Customer"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<body>
<% 

List<Customer> customerList=new ArrayList<>();

customerList.add(new Customer("Rajan","Chennai",false));
customerList.add(new Customer("Vishnu","Hyderabad",false));
customerList.add(new Customer("Mukund","Vizag",true));
customerList.add(new Customer("Kalai","Chennai",true));
customerList.add(new Customer("Banu","Delhi",false));

pageContext.setAttribute("custList",customerList);

%>
<table border=1>
<th>Customer Name</th>
<th>City</th>
<th>Discount Available</th>
<c:forEach items="${custList}" var="customer">
  <tr>
<td>${fn:(customer.customerName)}</td>
<td>${customer.customerCity}</td>
<td>

<c:if test="${customer.isPriviledged()}">  
   <c:out value="Special Discount"/><p>  
</c:if>  
<c:if test="${not customer.isPriviledged()}">  
   <c:out value="-"/><p>  
</c:if> 
</td>
</tr>  
</c:forEach>

</table>

</body>
</html>