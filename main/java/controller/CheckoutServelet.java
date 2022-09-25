package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import domain.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.OrderDAO;

import domain.Order;

/**
 * Servlet implementation class CheckoutServelet
 */
@WebServlet("/checkout.do")
public class CheckoutServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckoutServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getting cart
		HttpSession session = request.getSession(false);
		ArrayList<Product> lt = (ArrayList<Product>) session.getAttribute("cart");
		if (lt != null) {
			Iterator<Product> it = lt.iterator();
			String prodid;
			int unit;
			OrderDAO dao = new OrderDAO();
			while (it.hasNext()) {
				String customer_id = (String)session.getAttribute("customerid"); // customer object later
				Product current = it.next();
				prodid = current.getId();
				unit = 1;
				// create order object
				Random rand = new Random();
				//long seed = 950000000;
			    rand.setSeed(System.currentTimeMillis());
				String Order_id = Integer.toString(rand.nextInt(10000000)); // rand 
				Order ord = new Order(Order_id, customer_id, prodid, unit);
				dao.insertOrder(ord);
				it.remove();

			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("ViewCart.jsp");
		rd.forward(request, response);

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
