<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.logging.Logger"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC -HelloWorld</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

<script>
	$(function() {
		$("#automplete-3").autocomplete({

			source : function(request, response) {
				$.ajax({
					type : 'POST',
					url : 'http://localhost:8080/hibernate4/query', //your server side script
					dataType : 'json',
					data : {
						term : request.term
					},

					error : function() {
						alert('error');
					},

					success : function(data) {
						//                         alert("SUCCSSS");
						response(data);
					}
				});
			},

		/* 			select: function(event, ui) {
		 // prevent autocomplete from updating the textbox
		 event.preventDefault();
		 // manually update the textbox and hidden field
		 $(this).val(ui.item.label);
		 }
		 */
		});
	});

	$(document).ready(function() {
		$("table#t1 tr:even").css("background-color", "#BBBBBB");
		$("table#t1 tr:odd").css("background-color", "#EFF1F1");
	});
</script>
<style>
tr.even {
	background: yellow;
}

tr.odd {
	background: white;
}

tr.tri {
	background: red;
}
</style>

</head>
<body>
	<div class="container">
		<div jumbotron>
			<h1>boostrap css demo</h1>
			<h2>class jumbotron: Type a letter for user to see AJAX auto
				complete</h2>
			<div class="row">
				<div class="col-md-8">
					<div>
						<label for="automplete-3">grid 4 demo: </label>
					</div>

				</div>
				<div class="col-md-4">
					<div>
						<label for="automplete-3">grid 8 demo: </label>
					</div>

				</div>
			</div>
			<div class="row">
				<div class="col-md-8">
					<div>
						<input type="text" id="automplete-3" placeholder="user"
							class="form-control"></input>
					</div>

				</div>
				<div class="col-md-4">
					<div>
						<a href="#" class="btn btn-info btn-sm">Search</a>
					</div>

				</div>
			</div>
		</div>
		
			<h2>Hello this is person list, data are from MYSQL, bootstrap
				table-striped</h2>
			<table class="table table-striped">
				<tbody>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
					</tr>
					<c:forEach var="person" items="${persons}">
						<tr>
							<td>${person.id}</td>
							<td>${person.name}</td>
							<td>${person.country}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<h1>${message}</h1>

			<h2>forEach EL bootstrap table-hover</h2>

			<table class="table table-hover">
				<tbody>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
					</tr>
					<c:forEach var="account" items="${accounts}">
						<tr>
							<td>${account.ID}</td>
							<td>${account.firstName}</td>
							<td>${account.lastName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<br>
			<h2>forEach EL jquery CSS row striped</h2>

			<table id="t1">
				<tbody>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
					</tr>
					<c:forEach var="account" items="${accounts}">
						<tr>
							<td>${account.ID}</td>
							<td>${account.firstName}</td>
							<td>${account.lastName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<br>

			<h2>forEach EL CSS row striped using varStatus</h2>

			<table>
				<tbody>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
					</tr>
  <c:forEach var="account" items="${accounts}"  varStatus="lineInfo">
<c:choose>
   <c:when test="${lineInfo.count % 2 == 0}">
     <tr class="even"> 
   </c:when>
   <c:otherwise>
     <tr class="odd">
   </c:otherwise>
 </c:choose> 
							<td>${account.ID}</td>
							<td>${account.firstName}</td>
							<td>${account.lastName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<br>


			<br>
			<br>

			<h2>forEach, when, otherwise</h2>

			<table>
				<tbody>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
					</tr>
					<c:forEach var="account" items="${accounts}">
						<c:choose>
							<c:when test="${account.ID == '1' }">
								<tr class="odd">
									<td>${account.ID}</td>
									<td>${account.firstName}</td>
									<td>${account.lastName}</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr class="even">
									<td>${account.ID}</td>
									<td>${account.firstName}</td>
									<td>${account.lastName}</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</tbody>
			</table>

			<br>
			<br>

			<h2>if EL</h2>
			<c:set var="salary" scope="session" value="${2000*2}" />
			<c:if test="${salary > 2000}">
				<p>
					My salary is:
					<c:out value="${salary}" />
				<p>
			</c:if>


			<%
				Logger logger = Logger.getLogger(this.getClass().getName());
				String prefix = "Account ID is: ";
				logger.info(prefix + "initial;");
				logger.info(prefix + pageContext.findAttribute("message"));
				String msg = (String) pageContext.findAttribute("message");
			%>

			<h2>boostrap grid, old jsp scope access new jsp scope</h2>
			<div class="row">
				<div class="col-md-5">
					<p>row col-md-5, 4, 3 demo
					<p>
				</div>
				<div class="col-md-4">
					<p>pageContext.findAttribute is
					<p>
				</div>
				<div class="col-md-3">
					<p><%=msg%>
					<p>
				</div>
			</div>

			<table>
				<tbody>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
					</tr>
					<c:forEach var="account" items="${accounts}">
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
			<br>
			<br>

			<%-- c:url example --%>
			<div class="row">
				<div class="col-md-6">
						<a href="<c:url value="${google}"></c:url>" class="btn btn-info btn-sm">Google, doesn't go
				externally</a>
				</div>
				<div class="col-md-6">
						<a href="<c:url value="/google"></c:url>" class="btn btn-info btn-sm">Google, use
				redirect tag to go to external url</a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<a href="<c:url value="${google}"></c:url>">Google, doesn't go externally</a> 
				</div>
				<div class="col-md-6">
						<a href="<c:url value='/google'></c:url>">Google, use redirect tag to go to external url</a>
				</div>
			</div>
			<br>
			<br>
			<h1> Demo session variables set in controller</h1>
			<%-- c:set example to set variable value --%>
			<br>
				<c:out value="success: ${success}"></c:out>
			</br>
			<br>
				<c:out value="sessionObj: ${sessionObj.name}"></c:out>
			</br>

			<br>
				<c:out value="sessionScope.sessionObj: ${sessionScope.sessionObj.name}"></c:out>
			</br>

			<h1> var scope, exception, old out, new out</h1>
			<%-- c:set example to set variable value --%>
			<c:set var="id" value="request id" scope="request"></c:set>
			<c:set var="id" value="session id" scope="session"></c:set>
			</br>
			<c:out value="requestScope.id out: ${requestScope.id }"></c:out>
			</br>
			implicit id out, same id in session and request. the scope priority are pageScope, requestScope, sessionScope, plicationScope:
			<b>
				<c:out value= "${id }"></c:out>
			</b>
			<%-- c:set example to set variable value --%>
			<c:set var="who" value="Jackie" scope="session"></c:set>
			<c:set var="number" value="100" scope="session"></c:set>
			<c:set var="height" value="height" scope="session"></c:set>
			<%
				String who = (String) pageContext.findAttribute("who");
				int n = 100;
			%>
			</br>
				Old way, who out: <%=who%>
			</br>
				Old way, n out: <%=n%>


			<br>
				<c:out value="number out: ${number/2.6}"></c:out>
			<br>
			<%-- c:catch example --%>
			<c:catch var="e">
				<c:out value="${height/2.6}"></c:out>
			</c:catch>

			<c:if test="${e ne null}">
				<p>
					Exception is : ${e} <br /> Exception Message:
					${e.message}
				</p>
			</c:if>
			</br>
			
			<c:catch var="exception">
				<%

					int x = 5 / 0;
				%>
			</c:catch>

			<c:if test="${exception ne null}">
				<p>
					Exception is : ${exception} <br /> Exception Message:
					${exception.message}
				</p>
			</c:if>
			<br>
			<br>
			<br>
			<br>

		
	</div>
</body>
</html>