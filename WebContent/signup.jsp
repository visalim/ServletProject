<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
							<strong> Signup</strong>
						</div>
						<div class="panel-body">
							<form role="form" action="user" method="POST">
								<% if (request.getAttribute("error") != null) {%>
								<%=(String) request.getAttribute("error")%>
								<% } %>
								<fieldset>
									<div class="row">
										<div class="col-sm-12 col-md-10  col-md-offset-1 ">
											<div class="form-group">
												<div class="input-group">
													<span class="input-group-addon"> <i
														class="glyphicon glyphicon-user"></i>
													</span> <input class="form-control" placeholder="Name" name="name"
														type="text" autofocus>
														<% if (request.getAttribute("userNameError") != null) {%>
								<%=(String) request.getAttribute("userNameError")%>
								<% } %>
												</div>
											</div>
											<div class="form-group">
												<div class="input-group">
													<span class="input-group-addon"> <i
														class="glyphicon glyphicon-envelope"></i>
													</span> <input class="form-control" placeholder="Email"
														name="email" type="text" autofocus>
														<% if (request.getAttribute("emailError") != null) {%>
								<%=(String) request.getAttribute("emailError")%>
								<% } %>
												</div>
											</div>
											<div class="form-group">
												<div class="input-group">
													<span class="input-group-addon"> <i
														class="glyphicon glyphicon-lock"></i>
													</span> <input class="form-control" placeholder="Password"
														name="password" type="password" value="">
														<% if (request.getAttribute("passwordError") != null) {%>
								<%=(String) request.getAttribute("passwordError")%>
								<% } %>
												</div>
											</div>
											<div class="form-group">
												<input type="submit"
													class="btn btn-sm btn-primary btn-block" value="Sign in">
											</div>
										</div>
									</div>
								</fieldset>
							</form>
						</div>
						<div class="panel-footer ">
							Already have an account! <a href="#" onClick=""> Sign In Here
							</a>
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