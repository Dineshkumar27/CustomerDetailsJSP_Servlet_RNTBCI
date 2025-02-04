<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Thank you! you have registered Successfully

<h3>Your Data is</h3> <br/>
<%= request.getParameter("firstname") %><br/>
<%= request.getParameter("lastname") %>

your city is <%= request.getParameter("city") %>
<br/>

Thanks for choosing ${param.favoriteSubject }<br/>

<% 
String interest[]=request.getParameterValues("interest");
if(interest!=null)
for (String tempInterest:interest){
	out.println("<p>"+tempInterest+"</p>");
}
else
	out.println("<p>"+"selected nothing"+"</p>");
%>

got data from another method  ${param.firstname }   ${param.lastname }
</body>
</html>