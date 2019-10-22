package com.heraizen.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("name");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>first servlet</title></head>");
		out.print("<body>");

		if (userName != null || password != null) {
			if (userName.length() > 3) {
				HttpSession session = request.getSession();
				if (session.isNew()) {
					session.setAttribute("username", userName);
					
				}
				response.sendRedirect("viewproducts");
			} else {
				out.print("<p style='color:red'>You entered a bad cradentials</p>");
				request.getRequestDispatcher("index.jsp").include(request, response);

			}
		} else {
			out.print("<p style='color:red'>username and password is cann't be empty</p>");
			request.getRequestDispatcher("index.jsp").include(request, response);

		}
		out.print("</body>");
		out.print("</html>");
	}

}
