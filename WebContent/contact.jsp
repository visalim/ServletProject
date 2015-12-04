<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.phonebook.domain.Contact"%>
<%@ page import="java.util.Map"%>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<style>
			.error {
				color:red;
				font-size:12px;
			}
		</style>
	</head>
	<body>
	<% 
		Contact contact = (Contact)request.getAttribute("contact");
		Map<String, Object> errors = (Map<String,Object>)request.getAttribute("errors");
		boolean isNew = true;
		if(contact != null && contact.getId() != 0) {
			isNew = false;
		}
	%>
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
					<div class="col-sm-6 col-md-4 col-md-offset-4">
					
						<div class="panel panel-default">
							<div class="panel-heading">
								<strong>
								   <% if(isNew) { %>
									Add Contact
									<%} else { %>
									Update Contact
									<%} %>
								</strong>
							</div>
							<div class="panel-body">
								<form role="form" action='<%= isNew ? "contact" : "update" %>' method="POST">
								<input type="hidden" value="<%= isNew ? "" : contact.getId()%>" name="id"/>
									<fieldset>
										<div class="row">
											<div class="col-sm-12 col-md-10  col-md-offset-1 ">
												<div class="form-group">
													<div class="input-group">
														<span class="input-group-addon">
															<i class="glyphicon glyphicon-user"></i>
														</span> 
														<input class="form-control" placeholder="Name" name="name" type="text" value="<%= contact!=null?contact.getName():""%>" autofocus>
													</div>
													<% if(errors != null &&  errors.get("name") != null) { %>
															<span class="error"><%= errors.get("name") %></span>
													<% } %>
												</div>
												<div class="form-group">
													<div class="input-group">
														<span class="input-group-addon">
															<i class="glyphicon glyphicon-envelope"></i>
														</span> 
														<input class="form-control" placeholder="Email" name="email" value="<%=contact!=null?contact.getEmail():""%>" type="text" autofocus>
													</div>
													<% if(errors != null && errors.get("email") != null) { %>
														<span class="error"><%= errors.get("email") %></span>
													<% } %>
												</div>
												<div class="form-group">
													<div class="input-group">
														<span class="input-group-addon">
															<i class="glyphicon glyphicon-phone-alt"></i>
														</span>
														<input class="form-control" placeholder="Mobile" name="mobile" type="text" value="<%=contact!=null?contact.getMobile():""%>">
													</div>
													<% if(errors != null &&  errors.get("mobile") != null) { %>
														<span class="error"><%= errors.get("mobile") %></span>
													<% } %>
												</div>
												<div class="form-group">
													<input type="submit" class="btn btn-sm btn-primary btn-block" value="Save Contact">
												</div>
											</div>
										</div>
									</fieldset>
								</form>
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