<!DOCTYPE html>
<%@page import="com.phonebook.domain.Contact"%>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="custom.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="row panel-title">
					<div class="col-md-4">Welcome</div>
					<div class="col-md-4">
						<div class="input-group input-group-sm">
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-search"></span></span> <input type="text"
								class="form-control" placeholder="Search Contact">
						</div>
					</div>
				</div>
			</div>
			<div class="panel-body">
				<div class="col-sm-6 col-md-4 col-md-offset-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="row panel-title">
								<div class="col-md-5">Conact Details</div>

							</div>
						</div>
						<div class="panel-body">
							<table class="table table-user-information">
								<%
									Contact contact = (Contact) request.getAttribute("contact");
								%>
								<tbody>
									<tr>
										<td>Name:</td>
										<td><%=contact.getName()%></td>
									</tr>
									<tr>
										<td>Email:</td>
										<td><%=contact.getEmail()%></td>
									</tr>
									<tr>
										<td>Mobile</td>
										<td><%=contact.getMobile()%></td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="panel-footer ">
							<div class="row">
								<div class="col-md-4 pull-right">
									<button type="button" class="btn btn-primary btn-sm">
										<span class="glyphicon glyphicon-edit"></span> Edit
									</button>
								</div>
								<div class="col-md-3 pull-right">
									<button type="button" class="btn btn-danger btn-sm">
										<span class="glyphicon glyphicon-remove-circle"></span> Delete
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="panel-footer">
				<div class="row">
					<div class="col-sm-6 col-md-4 col-md-offset-4"></div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>