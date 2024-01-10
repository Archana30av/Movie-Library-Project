<%@page import="java.util.Base64"%>
<%@page import="dto.moviedto"%>
<%@page import="java.util.List"%>
<html>
<HEAD>
	<STYLE>
	body{
	background-color: gray;
	color: white;
	}
	a,button{
	border: 2px solid black;
	background-color: white;
	color: black;
	}
	table{
	border: 1px solid black;
	background-color:silver;
	color: black;
	}
	#nav{
	background-color: black;
	}
	</STYLE>
</HEAD>
<body>
<center>
<h2 id="nav">HOME</h2>


<%List<moviedto> movie=(List)request.getAttribute("movies");%>

<table border="1">
<thead>
<tr>
<th>id</th>
<th>Name</th>
<th>Rating</th>
<th>Genre</th>
<th>Language</th>
<th>Image</th>
<th>Delete</th>
<th>Edit</th>
</tr>
</thead>
<tbody>
<%for(moviedto m:movie){%>
<tr>
<td><%= m.getMovieid() %></td>
<td><%= m.getMoviename() %></td>
<td><%= m.getRating() %></td>
<td><%= m.getGenre() %></td>
<td><%= m.getLanguage() %></td>

<% String base64image = new String(Base64.getEncoder().encode(m.getImage()));%>
<td><img src="data:image/jpeg;base64, <%=base64image %>" height="100px" width="100px"></td>

<td><a href="deletemovie?id=<%=m.getMovieid()%>">Delete</a></td>	
<td><a href="editmovie?id=<%=m.getMovieid() %>">Edit</a></td>																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												
</tr>
<%}%>
</tbody>
</table>
<br><br>
<a href="addmovie.jsp">Add Movie</a>
</center>
</body>
</html>
  