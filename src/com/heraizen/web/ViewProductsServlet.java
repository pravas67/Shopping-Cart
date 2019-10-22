package com.heraizen.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heraizen.domain.ProductService;
import com.heraizen.domain.ProductServiceImpl;
import com.heraizen.domain.Products;

/**
 * Servlet implementation class ViewProductsServlet
 */
@WebServlet("/viewproducts")
public class ViewProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewProductsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		String username = null;
		if (session == null ) {
			response.sendRedirect("index.jsp");
		} else {
			username=(String) session.getAttribute("username");
		}
		ProductServiceImpl p=ProductServiceImpl.obj;
		List<Products> products=p.getProducts();
		
//		out.print("<html>");
//		out.print("<head><title>first servlet</title></head>");
//		out.print("<body>");
//		out.print("Welcome:&nbsp" +username);
//		out.print("<p><a href='logout'>Logout</a></p>");
//		out.print("<table>");
//		out.print("<tr><th>Name</th><th>price</th><th>Add to cart</th></tr>");
//		for (Products product : products) {
//			String pid=product.getPid();
//			String link="addtocart?pid="+pid;
//			out.print("<tr>");
//			out.print("<td>" + product.getPname() +"</td><td>" + product.getPrice()+ "</td><td><a href="+link+">Add To cart</a></td>");
//			out.print("</tr>");
//		}
//		out.print("</table>");
//		out.print("</body>");
//		out.print("</html>");
		request.setAttribute("products", products);
		request.getRequestDispatcher("viewproducts.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
