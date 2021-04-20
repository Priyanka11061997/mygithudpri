<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String msg=(String) request.getAttribute("errMsg"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(msg!=null && (msg.isEmpty())){ %>
<h1><%=msg %></h1>
<%} %>

<form action="./loginform" method="post">
id:<input type = "text" name="eid">
password:<input type = "text" name="pwd">
 

</form>

</body>
</html>