<html>
<head>
	<title>SignUp/Apply</title>
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
	#apply{
		border-radius :10px;
		align : center;
		padding : 2px;
	}
	input{
			border-radius :5px;
			padding : 2px;
	}
</style>
</head>
	<body>
	<h1 align ="center">Sign Up/Apply</h1>
	<hr>
	<form method="POST" action = "Signup">
	
	<label for="fuName">Full Name</label>
	<input type="text" id="fuName" name="fname" required><br><br>
	
	<label for="fatherName">Father Name</label>
	<input type="text" id="fatherName" name="fathername" required><br><br>
	
	<label for="doB">Date of Birth</label>
	<input type="date" id="doB" name="dob" min="1900-01-01" max="2022-12-20" required><br><br>	
	
	<label for="mobileNumber">Mobile Number</label>
	<input type="tel" id="mobileNumber" name="mobilenumber" pattern="[0-9]{10}"
       required><br><br>
	
	<label for="gaav_Sheher">Village/City</label>
	<input type="text" id="gaav_Sheher" name="gaav_sheher" required><br><br>
	
	<label for="jiLo">District</label>
	<input type="text" id="jiLo" name="jilo" required><br><br>
	
	<label for="pin_Code">PIN-CODE</label>
	<input type="number" id="pin_Code" name="pin_code" min="100000" max="999999" required><br><br>
	
	<label for="rajYa">State</label>
	<input type="text" id="rajYa" name="rajya" required><br><br>
	
	<input id = "apply" type="submit" value="Submit">
	
	</form>
	

	</body>			
</html>