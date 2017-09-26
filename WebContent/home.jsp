<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.bookerang.database.object.BrUsers" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<% 
BrUsers CurrentBrUser=(BrUsers)request.getSession().getAttribute("BrUser");
String CurrentBrUserName=CurrentBrUser.getUsername();
%>
<h1>Welcome <%=CurrentBrUserName%> </h1>
</body>
</html>