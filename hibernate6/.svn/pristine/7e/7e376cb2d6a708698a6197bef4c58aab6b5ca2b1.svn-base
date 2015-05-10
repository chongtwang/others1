<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.logging.Logger" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC -HelloWorld</title>
	<link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />

	<script type="text/javascript" 
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript" 
		src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

<script>

    $(function() {
        $("#automplete-3").autocomplete({

            source: function (request, response) {
                $.ajax({
                    type: 'POST',
                    url: 'http://localhost:8080/hibernate4/query', //your server side script
                    dataType: 'json',
                    data: {
                        term: request.term
                    },

					error: function()
					{alert('error');},

                    success: function (data) {
//                         alert("SUCCSSS");
                            response (data);
                    }
                });
            },
					
			select: function(event, ui) {
			// prevent autocomplete from updating the textbox
				event.preventDefault();
				// manually update the textbox and hidden field
				$(this).val(ui.item.label);
			}

        });
    });

</script>

</head>
<body>

      <div>
      <p>Type a letter for user</p>
         <label for="automplete-3">Tags: </label>
         <input id="automplete-3" placeholder="user">
      </div>

	<center>
		<h2>Hello this is person list, data are from MYSQL</h2>
	<table>
		<tbody>
			<tr><th>ID</th><th>First Name</th><th>Last Name</th></tr>
				<c:forEach var="person" items="${persons}" >
					<tr>
						<td>${person.id}</td>
						<td>${person.name}</td>
						<td>${person.country}</td>
					</tr>
				</c:forEach>
		</tbody>
	</table>

		<h2>
			${message}
		</h2>

		<h2>forEach EL</h2>

	<table>
		<tbody>
			<tr><th>ID</th><th>First Name</th><th>Last Name</th></tr>
				<c:forEach var="account" items="${accounts}" >
					<tr>
						<td>${account.ID}</td>
						<td>${account.firstName}</td>
						<td>${account.lastName}</td>
					</tr>
				</c:forEach>
		</tbody>
		</table>
	<br><br>

		<h2>forEach EL</h2>

	<table>
		<tbody>
			<tr><th>ID</th><th>First Name</th><th>Last Name</th></tr>
				<c:forEach var="account" items="${accounts}" >
					<tr>
						<td>${account.ID}</td>
						<td>${account.firstName}</td>
						<td>${account.lastName}</td>
					</tr>
				</c:forEach>
		</tbody>
		</table>
	<br><br>

		<h2>if EL</h2>
<c:set var="salary" scope="session" value="${2000*2}"/>
<c:if test="${salary > 2000}">
   <p>My salary is: <c:out value="${salary}"/><p>
</c:if>


<% 
	Logger logger=Logger.getLogger(this.getClass().getName());
   	String prefix = "Account ID is: ";
   	logger.info( prefix + "initial;" );
   	logger.info( prefix +  pageContext.findAttribute("message") );
   	
%>
	<table>
		<tbody>
			<tr><th>ID</th><th>First Name</th><th>Last Name</th></tr>
				<c:forEach var="account" items="${accounts}" >
					<c:if test="${account.ID!='2'}">
					<tr>
						<td>${account.ID}</td>
						<td>${account.firstName}</td>
						<td>${account.lastName}</td>
					</tr>
					</c:if>
				</c:forEach>
		</tbody>
		</table>
	<br><br>
			
	<%-- c:set example to set variable value --%>
	<c:set var="id" value="5" scope="request"></c:set>
	</br>
	<c:out value="${requestScope.id }" ></c:out>
	<br><br>
	<%-- c:catch example --%>
	<c:catch var ="exception">
	   <% int x = 5/0;%>
	</c:catch>
	 
	<c:if test = "${exception ne null}">
	   <p>Exception is : ${exception} <br />
	   Exception Message: ${exception.message}</p>
	</c:if>
	<br><br>
	<%-- c:url example --%>
	<a href="<c:url value="${google}"></c:url>">Google, doesn't go externally</a>	</center>

	<a href="<c:url value="/google"></c:url>">Google, use redirect tag to go to external url</a>	</center>
	
</body>
</html>