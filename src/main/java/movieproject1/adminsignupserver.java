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

@WebServlet("/sigupserver")
public class adminsignupserver extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		int id=Integer.parseInt(req.getParameter("adminid"));
		String name=req.getParameter("adminname");
		long contact=Long.parseLong(req.getParameter("admincontact"));
		String email=req.getParameter("adminemail");
		String password=req.getParameter("adminpassword");
		
		admindto adto1=new  admindto();
		adto1.setId(id);
		adto1.setName(name);
		adto1.setContact(contact);
		adto1.setEmail(email);
		adto1.setPassword(password);
		
		admindao adao1=new admindao();
		try {
			adao1.saveadmin(adto1);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
