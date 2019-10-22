package com.heraizen.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heraizen.domain.ProductService;
import com.heraizen.domain.ProductServiceImpl;
import com.heraizen.domain.Products;
import com.sun.javafx.collections.MappingChange.Map;

/**
 * Servlet implementation class RemoveServlet
 */
@WebServlet("/remove")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		String pid =request.getParameter("pid");
		ProductService p = ProductServiceImpl.obj;
		java.util.Map<String, Products> products=new HashMap<String, Products>();
		if(session!=null)
		{
			 List<Products> list= (List<Products>) session.getAttribute("cartitem");
			 if(list!=null)
			 {
				 products = list.stream()
                         .collect( Collectors.toMap(Products::getPid,Function.identity()) );
			 }
			
			 products.remove(pid);
			 List<Products> pro=products.values().stream().collect(Collectors.toList());
			 session.setAttribute("cartitem", pro);
			 request.setAttribute("products", products);
			 request.getRequestDispatcher("viewCart.jsp").forward(request, response);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
