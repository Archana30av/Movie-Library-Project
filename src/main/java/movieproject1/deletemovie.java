package movieproject1;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.admindao;

@WebServlet("/deletemovie")
public class deletemovie extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			int id=Integer.parseInt(req.getParameter("id"));
			
			try {
				admindao d1=new admindao();
				d1.deletemovie(id);
				
				req.setAttribute("movies", d1.getallmovies());
				
				RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
				rd.include(req, resp);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

