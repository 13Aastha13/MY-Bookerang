package com.bookerang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.StyledEditorKit.BoldAction;

import com.bookerang.database.dao.BrUsersDao;
import com.bookerang.database.object.BrUsers;
import com.bookerang.main.BrConstants;

/**
 * Servlet implementation class SecurityServlet
 */
//@WebServlet("/SecurityServlet")
public class SecurityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecurityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email=request.getParameter("email");
		String action=request.getParameter("action");
		String password=request.getParameter("password");
		PrintWriter out = response.getWriter();
		//response.setContentType("text/html;charset=UTF-8");
		if(action.equals("login"))
		{
			List<BrUsers> lbu =BrUsersDao.getUser(email, password);
			if(lbu.size()==1)
			{
			
				HttpSession mySession = request.getSession();
				mySession.setMaxInactiveInterval(BrConstants.MAX_TIMEOUT);
				mySession.setAttribute("BrUser", lbu.get(0));
				out.print("SUCCESS");
				//String BrName=lbu.get(0).getUsername();
				//RequestDispatcher rdp= request.getRequestDispatcher("../../../../../WebContent/home.jsp");
				// RequestDispatcher rdp=  getServletContext().getRequestDispatcher("/home.jsp");
				//rdp.forward(request, response);
				
			}
			else 
			{
				out.print("FAILURE");
			}
			
		}
		
		/*if(email.equalsIgnoreCase("aastha.singhal@alstom.com")&& password.equals("Albus13#"))
		{
		
			HttpSession mySession = request.getSession();
			mySession.setMaxInactiveInterval(BrConstants.MAX_TIMEOUT);
			mySession.setAttribute("BrUser", "Aastha");
			//String BrName=lbu.get(0).getUsername();
			//RequestDispatcher rdp= request.getRequestDispatcher("../../../../../WebContent/home.jsp");
			 //RequestDispatcher rdp=  getServletContext().getRequestDispatcher("/test.jsp");
			//rdp.forward(request, response);
			//response.sendRedirect(request.getContextPath()+"/test.jsp");
			//return;
		}*/
		
	
	}

}
