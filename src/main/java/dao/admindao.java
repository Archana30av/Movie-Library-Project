																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																		package dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import com.mysql.cj.protocol.Resultset;

import dto.admindto;
import dto.moviedto;
import movieproject1.movieserver;

public class admindao {
	
	public Connection getconnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/movieproject","root","root");
	}
	public int saveadmin(admindto a) throws ClassNotFoundException, SQLException {
		
		Connection con=getconnection();
		
		PreparedStatement ps1=con.prepareStatement("insert into admin values(?,?,?,?,?)");
		ps1.setInt(1, a.getId());
		ps1.setString(2, a.getName());
		ps1.setLong(3, a.getContact());
		ps1.setString(4, a.getEmail());
		ps1.setString(5, a.getPassword());
		
		return ps1.executeUpdate();
	}
	public admindto findbyemail(String email) throws ClassNotFoundException, SQLException {
		
		Connection con=getconnection();
		PreparedStatement ps1=con.prepareStatement("select * from admin where email=?");
		ps1.setString(1, email);
		
		ResultSet rs= ps1.executeQuery();
		admindto a1=null;
		while(rs.next())
		{
		a1=new admindto();
		a1.setId(rs.getInt(1));
		a1.setName(rs.getString(2));
		a1.setContact(rs.getLong(3));
		a1.setEmail(rs.getString(4));
		a1.setPassword(rs.getString(5));
		}
		return a1;
	}
	public int savemovie(moviedto m) throws ClassNotFoundException, SQLException {
		
		Connection con=getconnection();
		PreparedStatement ps1=con.prepareStatement("insert into movielib values(?,?,?,?,?,?)");
		ps1.setInt(1, m.getMovieid());
		ps1.setString(2, m.getMoviename());
		ps1.setDouble(3, m.getRating());
		ps1.setString(4, m.getGenre());
		ps1.setString(5, m.getLanguage());
		
		Blob imageblob=new SerialBlob(m.getImage()); //converts byte image to blob
		ps1.setBlob(6, imageblob);
		
		return ps1.executeUpdate();
	}
	public List<moviedto> getallmovies() throws ClassNotFoundException, SQLException{
		Connection c=getconnection();
		PreparedStatement ps1=c.prepareStatement("select * from movielib");
		ResultSet rs=ps1.executeQuery();
		List<moviedto> movies=new ArrayList<moviedto>();
		
		while(rs.next()) {
		moviedto m1=new moviedto();
		m1.setMovieid(rs.getInt(1));
		m1.setMoviename(rs.getString(2));
		m1.setRating(rs.getInt(3));
		m1.setGenre(rs.getString(4));
		m1.setLanguage(rs.getString(5));
		
		Blob b=rs.getBlob(6);
		byte[] image=b.getBytes(1, (int)b.length());
		m1.setImage(image);
		
		movies.add(m1);
		//System.out.println(movies);
		}
		return movies;
	}
	public int deletemovie(int id) throws ClassNotFoundException, SQLException {
		Connection c=getconnection();

		PreparedStatement ps1=c.prepareStatement("delete from movielib where movieid=(?)");
		ps1.setInt(1, id);
		
		return ps1.executeUpdate();
		
	}
	public moviedto findMovieById(int movieId) throws ClassNotFoundException, SQLException {
		Connection conn = getconnection();
		PreparedStatement pst = conn.prepareStatement("select * from movielib where movieid = ?");
		pst.setInt(1, movieId);
		ResultSet rs = pst.executeQuery();
		rs.next();
		moviedto m = new moviedto();
		m.setMovieid(rs.getInt(1));
		m.setMoviename(rs.getString(2));
		m.setRating(rs.getDouble(3));
		m.setGenre(rs.getString(4));
		m.setLanguage(rs.getString(5));
		Blob b = rs.getBlob(6);
		byte[] img = b.getBytes(1, (int)b.length());
		m.setImage(img);
		return m;
	}
	public int updateMovie(moviedto movie) throws ClassNotFoundException, SQLException {
		Connection conn = getconnection();
		PreparedStatement pst = conn.prepareStatement("update movielib set moviename=?,rating=?,genre=?,language=?,image=? where movieid=?");
		
		pst.setString(1, movie.getMoviename());
		pst.setDouble(2, movie.getRating());
		pst.setString(3, movie.getGenre());
		pst.setString(4, movie.getLanguage());
		Blob imageBlob = new SerialBlob(movie.getImage());
		pst.setBlob(5, imageBlob);
		pst.setInt(6, movie.getMovieid());
		
		return pst.executeUpdate();
	}
	
}
  