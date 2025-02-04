<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page for Favorite Language</title>
</head>
<body>
<%

String favLang="Java";

Cookie myCookies[]=request.getCookies();
		
for(Cookie tempCookie:myCookies){
	if("myfavoritelang".equals(tempCookie.getName())){
		favLang=tempCookie.getValue();
	}
}
		
		


%>

<h1>Your Favorite Language now <%=favLang %></h1>
<a href="ChangeLanguage.html">Change your Favorite language here</a>
</body>
</html>