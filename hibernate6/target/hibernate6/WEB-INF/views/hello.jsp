<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC -HelloWorld</title>
</head>
<body>
	<center>
		<h2>Hello World</h2>
		<h2>
			${message}
		</h2>
		<h2><%="old jsp"%></h2>
		<% String s = (String)pageContext.findAttribute("message"); %>
		<c:set var="myCount" value="${message}" />
		<h2><%="Find variable in JSTL from old JSP: " + s%></h2>
	</center>
</body>
</html>