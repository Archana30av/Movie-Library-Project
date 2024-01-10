package movieproject1;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.RequestDispatcher;

import dao.admindao;
import dto.moviedto;

@WebServlet("/editmovie")
public class editmovie extends  HttpServlet{
		
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
			int id = Integer.parseInt(req.getParameter("id"));
			
			try {
				admindao adao1 = new admindao();
				moviedto m = adao1.findMovieById(id);
				req.setAttribute("movie", m);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
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
			
		
