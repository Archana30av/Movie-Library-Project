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
import dto.admindto;
import dto.moviedto;

@WebServlet("/adminloginserver")
public class adminloginserver extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("adminemail");
		String password=req.getParameter("adminpassword");

		try {
			admindao adao1=new admindao();
			admindto adto1 = adao1.findbyemail(email);
			
			if(adto1!=null) {
				if(adto1.getPassword().equals(password)) {
					
					req.setAttribute("movies", adao1.getallmovies());
					
					RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
					rd.include(req, resp); }
				
				else {
					req.setAttribute(  "msg", "Password is Wrong");
					RequestDispatcher rd=req.getRequestDispatcher("adminlogin.jsp");
					rd.include(req, resp);
				}
			}
			else {
				req.setAttribute( "msg","Email is Wrong");
				RequestDispatcher rd=req.getRequestDispatcher("adminlogin.jsp");
				rd.include(req, resp);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
