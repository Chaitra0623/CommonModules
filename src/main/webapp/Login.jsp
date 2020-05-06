<!DOCTYPE html>
<html lang="en">
<head>
<style>
body {	
	height: 400px; /* You must set a specified height */	
}
</style>
<title>REGISTER FORM</title>
<link rel="stylesheet" type="text/css" href="Style.css"></link>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="footer">
		<p>Footer</p>
	</div>
	<nav class="navbar navbar-inverse" >
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">x-workz Commom Modules</a>
			</div>
			<ul class="nav navbar-nav">
			</ul>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="Home.jsp"><span
					class="glyphicon glyphicon-user "></span> Home</a></li>
			<li><a href="Register.jsp"><span
					class="glyphicon glyphicon-log-in"></span> Register</a></li>
		</ul>
	</nav>
	<div>
		<div class="container">
			<h2>Login form.......!!!!</h2>
			<h4>${msg}</h4>
			<form action="Login.do" method="post">
				
				<div class="form-group" style="color: white">
					<label for="email">Email:</label> <input type="text"
						class="form-control" id="email" placeholder="Enter email"
						name="email" required>
				</div>
				<div class="form-group" style="color: white">
					<label for="password">Password:</label> <input type="text"
						class="form-control" id="password" placeholder="Enter password"
						name="password" required>
 				</div>
 				
				
				</div>

			<text onclick="window.location.href = 'ForgotPassword.jsp';">ForgotPassword</text>
			


				<button type="submit" class="btn btn-default">Login</button>
			<span style="color: red; font-family: cursive;">${failuremessage}</span>
				
			</form>
		</div>
	</div>

	



	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: black;
	color: white;
	text-align: center;
}
</style>
</body>
</html>
