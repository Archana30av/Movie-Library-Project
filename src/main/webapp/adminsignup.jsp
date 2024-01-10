<html>
<HEAD>
	<STYLE>
	body{
	background-color: gray;
	color: white;
	}
	input, button{
	border: 2px solid black;
	background-color: white;
	color: black;
	}
	#nav{
	background-color: black;
	}
	</STYLE>
</HEAD>
<body>
<center>
<h2 id="nav">ADMIN SIGNUP</h2>

<form action="sigupserver" method="post">
ID :        <input type="number" name="adminid" placeholder="Enter id"> <br><br>
NAME :      <input type="text" name="adminname" placeholder="Enter name"> <br><br>
CONTACT :   <input type="tel" name="admincontact" placeholder="Enter phone no." pattern="[0-9]{10}"> <br><br>
E-MAIL :    <input type="email" name="adminemail" placeholder="abc@gmail.com"> <br><br>
PASSWORD :  <input type="password" name="adminpassword" placeholder="Enter 8 char(include 0-9)" pattern="{8}"> <br><br>
<button>SUBMIT</button>
</form>
</center>
</body>
</html>
