
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String names[]={"Raj","Farook","Ganesh","Joseph"};
pageContext.setAttribute("friends", names);

%>
<c:forEach items="${friends}" var="element">
    The element value is ${fn:toUpperCase(element)} <br/>
</c:forEach>



<c:forEach items="${individualcust}" var="onecust">
    The element value is ${fn:toUpperCase(onecust)} <br/>
</c:forEach>
</body>
</html>