<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
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
</head>
<body>
	<div class="footer">
		<p>Footer</p>
	</div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">x-workz Commom Modules</a>
			</div>
			<ul class="nav navbar-nav">
			</ul>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="Home.jsp"><span class="glyphicon glyphicon-user " ></span>
					Home</a></li>
			<li><a href="Login.jsp"><span class="glyphicon glyphicon-log-in"></span>
					Login</a></li>
		</ul>
	</nav>
	<div class="container">
			<h2>ForgotPassword form.......!!!!</h2>
			<h4>${msg}</h4>
			<form action="Forgot.do" method="post">
				<div class="form-group" style="color: white">
					<label for="mail">mail:</label> <input type="text"
						class="form-control" id="mail" placeholder="Enter mail"
						name="email" required>
	              </div>
	  <button type="submit" class="btn btn-default">Reset</button>
	</form>
	</div>
</body>
</html>
