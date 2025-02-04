<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<jsp:include page="Header.html" />
<h1>Hello All! Welcome to JSP</h1>

<%= 6+8*4 %>
<%= request.getHeader("User-Agent") %>
<br/>
<%= request.getLocale() %>
<%out.println("Welcome to JSP"); %>

<%
response.sendRedirect("Firstservlet2");
%>
</body>
</html>