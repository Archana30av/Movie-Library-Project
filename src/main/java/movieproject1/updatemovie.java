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


	@WebServlet("/updatemovie")
	@MultipartConfig(maxFileSize = 5*1024*1024)
	public class updatemovie extends HttpServlet{
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			int movieid= Integer.parseInt(req.getParameter("movieid"));
			String moviename = req.getParameter("moviename");
			double movierating =  Double.parseDouble(req.getParameter("movierating"));
			String moviegenre = req.getParameter("moviegenre");
			String movielanguage = req.getParameter("movielanguage");
			Part imagepart  = req.getPart("movieimage");
			
			moviedto movie = new moviedto();
			movie.setMovieid(movieid);
			movie.setGenre(moviegenre);
			movie.setLanguage(movielanguage);
			movie.setRating(movierating);
			movie.setMoviename(moviename);
			
			//IF WE UPDATE IMAGE
			if(imagepart.getInputStream().readAllBytes().length>0)
				movie.setImage(imagepart.getInputStream().readAllBytes());
			else
			{
				//IF U DIDNT UPDATE IMAGE, RESTORE OLD IMAGE
				admindao adao1 = new admindao();
				moviedto m;
				try {
					m = adao1.findMovieById(movieid);
					byte[] img=m.getImage();
					movie.setImage(img);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				admindao adao1 = new admindao();
				adao1.updateMovie(movie);
				
				req.setAttribute("movies", adao1.getallmovies());
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
				dispatcher.include(req, resp);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
                                                                                                                                                                                                                