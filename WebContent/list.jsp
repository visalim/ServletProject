<%@page import="com.phonebook.domain.Contact"%>
<%@page   import="java.util.List" %>
<%@page import="com.phonebook.domain.impl.ContactImpl" %>
<%-- <%@page import="com.phonebook.web.list.ListController"%> --%>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="custom.css" rel="stylesheet">
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
	</head>
	<body>
		<div class="container">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="row panel-title">
						<div class="col-md-4">Welcome</div>
						<div class="col-md-4">
							<div class="input-group input-group-sm">
							  <span class="input-group-addon"><span class="glyphicon glyphicon-search"></span></span>
							  <input type="text" class="form-control" placeholder="Search Contact">
							</div>
						</div>
					</div>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-12">
							<div class="table-responsive">
							  <table class="table table-bordered table-striped">
							  <% List<ContactImpl> contacts=(List<ContactImpl>)request.getSession().getAttribute("List"); %>
									<tr>
										<th><span class="glyphicon glyphicon-user"></span> id</th>
										<th><span class="glyphicon glyphicon-envelope"></span> Name</th>
										<th><span class="glyphicon glyphicon-phone-alt"></span>Email</th>
										<th><span class="glyphicon glyphicon-tasks"></span> Action</th>
									</tr>
									<%for(ContactImpl contact:contacts){ %>
									<tr>
										<td>
										    <%=contact.getName()%>
										    
										</td>
										<td>
										<%=contact.getEmail()%>
										</td>
										<td>
										<%=contact.getMobile()%>
										</td>
										<td> <a href="edit?id=<%=contact.getId()%>">Edit</a></br>
											<a href="delete?id=<%=contact.getId()%>">Delete</a>
										</td>
									</tr>
									<%} %>
									
							  </table>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-footer">
					<div class="row">
						<div class="col-sm-6 col-md-4 col-md-offset-4">
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>