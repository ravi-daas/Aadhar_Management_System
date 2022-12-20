<html>
<head>
	<title>LogIn</title>
<style>
	button{
		border-radius :10px;
		align : center;
		padding : 2px;
	}
	a{
		text-decoration : none;
		color : white;
	}
	input{
			border-radius :5px;
			padding : 2px;
	}
</style>
</head>
	<body>
	<h1 align ="center">Log In</h1>
	<hr>
	<form method="POST" action = "Login">
	
	<label for="aadhar">Aadhar Number</label>
	<input type="text" id="aadhar" name="aadhaR" required><br><br>
	
	<label for="mobileNumber">PassWord</label>
	<input type="password" id="mobileNumber" name="mobilenumber" pattern="[0-9]{10}"
       required placeholder="Phone Number"><br><br>
	
	
	<input type="submit" value="Submit">
	
	</form>
		</body>			
</html>