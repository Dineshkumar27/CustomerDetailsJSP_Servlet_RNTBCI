<%@ page import="java.util.ArrayList,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
<input type="text" name="theItem"/>
<input type="submit" value="addtolist"/>

</form>
<hr>

<%
//checking the session mytodolist is exist
 List<String> itemList=(List<String>)session.getAttribute("mytodolist");
//if not exist create a list and add to the session
if(itemList==null){
	itemList=new ArrayList<String>();
	session.setAttribute("mytodolist", itemList);
	
}

String item=request.getParameter("theItem");
boolean validateItem=item!=null && item.trim().length()>0 && !itemList.contains(item.trim());
if(validateItem)
	itemList.add(item);
%>

<ol>
<% 
//display the to do list
for(String item1:itemList){
	out.println("<li>"+item1+"</li>");
}
%>


</ol>
</body>
</html>