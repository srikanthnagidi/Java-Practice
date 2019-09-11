package com.eample.firstservlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class XmlServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("from xml servlet path");
		response.setContentType("text/html;charset = UTF-8");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		HttpSession session = request.getSession();
		if (!userName.isEmpty() && userName != null) {
			session.setAttribute("savedUserName", userName);
		}
		
		out.println("hello from the get method " + userName);
		out.println("<br>your id is " + userId);
		out.println("<br> Session parameter has user name as " + (String)session.getAttribute("savedUserName"));
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>First Servlet Program</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2> Servlet from xml path " + request.getContextPath() + " </h2>");
			out.println("</body>");
			out.println("</html>");
		}finally {
			out.close();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("from xml servlet path and ");
		response.setContentType("text/html;charset = UTF-8");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String email = request.getParameter("emailaddress");
		out.println("hello from the Post method " + userName);
		out.println("<br>your id is " + userId);
		out.println("<br> your email address is " + email);
		String prof = request.getParameter("prof");
		out.println("<br>You are a " + prof);
		String[] places = request.getParameterValues("location");
		out.println("<br> you live in " );
		for (String st: places)out.print(st + " ");
	}

}
