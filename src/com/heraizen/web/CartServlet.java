package com.heraizen.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * Servlet implementation class AddToCart
 */
@WebServlet("/addtocart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		String pid =request.getParameter("pid");
		ProductService p = ProductServiceImpl.obj;
		List<Products> products=new ArrayList<>();
		if(session!=null)
		{
			 Object object= session.getAttribute("cartitem");
			 if(object!=null)
			 {
				 products=(List<Products>) object;
			 }
			 products.add(p.getProduct(pid));
			 session.setAttribute("cartitem", products);
			 addTocart(session, request, response,products);
		}
	}
	private void addTocart(HttpSession session, HttpServletRequest request, HttpServletResponse response, List<Products> products)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
//		List<Products>productslist = (List<Products>) session.getAttribute("cartitem");
		request.setAttribute("products", products);
		request.getRequestDispatcher("viewCart.jsp").forward(request, response);
		
//		out.print("<html>");
//		out.print("<head><title>first servlet</title></head>");
//		out.print("<body>");
//
//		out.print("<table>");
//		out.print("<tr><th>Name</th><th>price</th><th>checkout</th></tr>");
//		for(Products product:products)
//		{
//		out.print("<tr>");
//		out.print("<td>" + product.getPname() + "</td>");
//		out.print("<td>" + product.getPrice()+ "</td>");
//		//out.print("<td><a href='addtocart'>Add To cart</a></td>");
//		out.print("</tr>");
//		}
//		out.print("<a href='viewproducts'>view Products</a>");
//		out.print("</table>");
//		out.print("</body>");
//		out.print("</html>");

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
