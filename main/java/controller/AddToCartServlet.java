package controller;

import java.io.IOException;
import domain.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import dao.ProductDataObject;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/addc.do")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession(false);
		
		ArrayList<Product> sessioncart = (ArrayList<Product>)session.getAttribute("cart");
		ProductDataObject dao = new ProductDataObject();
		if(sessioncart==null) {
			ArrayList<Product> cart = new ArrayList<Product>();
			cart.add(dao.getProductById(request.getParameter("id")));
			session.setAttribute("cart",cart);
		}else {
			sessioncart.add(dao.getProductById(request.getParameter("id")));
		}
		RequestDispatcher rd = request.getRequestDispatcher("ViewCart.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
