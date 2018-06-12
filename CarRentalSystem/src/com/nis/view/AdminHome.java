package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.model.AdminModel;

/**
 * Servlet implementation class AdminHome
 */
@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
		HttpSession ses=request.getSession();
		try{
			AdminModel A=(AdminModel)ses.getValue("SADMIN");
			String ltime=ses.getValue("LTIME").toString();
			String sn="<b>Id:" +A.getAdminid()+"&nbsp;&&nbsp;&nbsp;&nbsp;nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+A.getAdminname()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ltime+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"<a href=AdminLogut>Logout</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=images/uni/"+A.getPicture()+" width=25 height=25></b><br><hr color=red>";			
			out.println(sn);		
		}
		catch(Exception e){
			response.sendRedirect("AdminLogin");
		}
		out.println("<table>");
		out.println("<tr>");
		out.println("<td valign=top>");
		out.println("<a href=AddCars target='mw'>Add Cars</a><br>");
		out.println("<a href=DisplayAllCars target='mw'>Display Cars</a><br>");
		out.println("<a href=CarsEditDelete target='mw'>Edit/Delete Cars</a><br>");
		out.println("<td>");
		out.println("<td valign=top>");
        out.println("<iframe width=700 height=700 frameborder=0 name=mw></iframe>");
        out.println("</td>");
        out.println("</table></html>");
        
		
		
		
		
		
	}

}
