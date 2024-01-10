package movieproject1;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.admindao;
import dto.moviedto;

@WebServlet("/movieserver")
@MultipartConfig(maxFileSize = 10 * 1024 * 1024)
public class movieserver extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int movieid=Integer.parseInt(req.getParameter("movieid"));
		String moviename=req.getParameter("moviename");
		int rating=Integer.parseInt(req.getParameter("rating"));
		String genre =req.getParameter("genre");
		String language=req.getParameter("language");
		Part p=req.getPart("image");
		
		moviedto m1=new moviedto();
		m1.setMovieid(movieid);
		m1.setMoviename(moviename);
		m1.setRating(rating);
		m1.setGenre(genre);
		m1.setLanguage(language);
		m1.setImage(p.getInputStream().readAllBytes());
		
		try {
			admindao adao1=new admindao();
			adao1.savemovie(m1);
			 
			req.setAttribute("movies",  adao1.getallmovies());
			
			RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
			rd.include(req, resp);
				
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
  