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
<h2 id="nav">ADMIN LOGIN</h2>


<form action="adminloginserver" method="post">

E-MAIL :    <input type="email" name="adminemail" placeholder="abc@gmail.com"> <br><br>
PASSWORD :  <input type="password" name="adminpassword" placeholder="Enter 8 char(include 0-9)" pattern="{8}"> <br><br>
<%String msg=(String)request.getAttribute("msg"); %>
<%if(msg!=null){%>
<%=msg%>
<%} %>
<br><br>
<button>SUBMIT</button>
</center>

</form>
</body>
</html>
