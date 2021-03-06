<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="custom.css" rel="stylesheet">
<script src="jquery/jquery-1.11.3.min.js"></script>
<script>
	
	/*function isValidUsername() {
		var usernameField = $("#username");
		var username = usernameField.val();
		if (username.length != 0 && username.length >= 10) {
			return true;
		} else {
			return false;
		}
	}
	function isValidPassword() {
		var passwordField = $("#password");
		var password = passwordField.val();
		if (password.length != 0) {
			return true;
		} else {
			return false;
		}
	}
	function  isvalidForm() {
				if (!isValidUsername()) {
					alert("disable");
					$("#password").prop('disabled',true);
					
				}else{
					alert("enable");
					$("#password").prop('disabled',false);
				}
				return false;
	}*/
	$(document).ready(function(){
		$("#username").keyup(function(){
			var usernameField = $("#username");
			var passwordField = $("#password");
			var username = usernameField.val();
			if(username.length != 0 && username.length>=10){
				$("#password").prop("disabled",false);
			}else{
				$("#password").prop("disabled",true);
			}
			
		});
	});


</script>
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
							<strong> Sign in to continue</strong>
						</div>
						<div class="panel-body">
							<form role="form" action="login" method="POST"
								onsubmit="return isvalidForm()">
								<%
									if (request.getAttribute("error") != null) {
								%>
								<%=(String) request.getAttribute("error")%>
								<%
									}
								%>
								<fieldset>
									<div class="row">
										<div class="col-sm-12 col-md-10  col-md-offset-1 ">
											<div class="form-group">
												<div class="input-group">
													<span class="input-group-addon"> <i
														class="glyphicon glyphicon-user"></i>
													</span> <input class="form-control" placeholder="Username"
														name="email" type="text" autofocus id="username">
													<%
														if (request.getAttribute("usernameerror") != null) {
													%>
													<%=(String) request.getAttribute("usernameerror")%>
													<%
														}
													%>
												</div>
											</div>
											<div class="form-group">
												<div class="input-group">
													<span class="input-group-addon"> <i
														class="glyphicon glyphicon-lock"></i>
													</span> <input class="form-control" placeholder="Password"
														name="password" type="password" value="" id="password">
													<%
														if (request.getAttribute("passworderror") != null) {
													%>
													<%=(String) request.getAttribute("passworderror")%>
													<%
														}
													%>

												</div>
											</div>
											<div class="form-group">
												<input type="submit" id="submit"
													class="btn btn-sm btn-primary btn-block" value="Sign in">

											</div>
										</div>
									</div>
								</fieldset>
							</form>
						</div>
						<div class="panel-footer ">
							Don't have an account! <a href="#" onClick=""> Sign Up Here </a>
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