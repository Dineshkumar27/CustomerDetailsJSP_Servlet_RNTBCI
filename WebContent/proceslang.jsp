<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String favLang="Java";

favLang=request.getParameter("favLang");

Cookie cookie=new Cookie("myfavoritelang",favLang);

cookie.setMaxAge(60*60*24*365);

response.addCookie(cookie);





%>
<p> Thank you for choosing new language <%= favLang %>
<a href="homepage.jsp">Go back to Home Page</a>
</body>
</html>