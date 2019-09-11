package com.eample.firstservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "A simple servlet", urlPatterns = { "/SimpleServletPath" },
		initParams = {@WebInitParam(name="defaultUser", value="Joh Doe")})
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("From doGet Method");
		response.setContentType("text/html;charset = UTF-8");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		HttpSession session = request.getSession();
		if (userName != "" && userName != null) {
			session.setAttribute("savedUserName", userName);
		}
		out.println("Request parameter has userName is " + userName);
		out.println("<br> Session parameter has user name as " + (String)session.getAttribute("savedUserName"));
		
		out.println("<br>Init Parameter has default userName as " + this.getServletConfig().getInitParameter("defaultUser"));
	}

}
