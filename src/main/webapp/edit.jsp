<%@page import="dto.moviedto"%>
<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% moviedto m = (moviedto)request.getAttribute("movie");  %>

	<form action="updatemovie" method="post" enctype="multipart/form-data">
		ID :<input type="text" name="movieid" value="<%= m.getMovieid() %>" readonly><br>
		moviename<input type="text" name="moviename" value="<%= m.getMoviename() %>"><br>
		movierating<input type="text" name="movierating" value="<%= m.getRating() %>"><br>
		moviegenre<input type="text" name="moviegenre" value="<%= m.getGenre() %>"><br>
		movielanguage<input type="text" name="movielanguage" value="<%= m.getLanguage()%>"><br>
		
		movieimage<input type="file" name="movieimage"><br>
		<input type="submit">
		
		
		<% String base64image = new String(Base64.getEncoder().encode(m.getImage())); %>
		<img  src="data:image/jpeg;base64 , <%= base64image %>" height="150px" width="100px" >
	</form>
	
		

</body>
</html>