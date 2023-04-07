package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import domain.Customer;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO create a customer object and insert in table using dao
		Random rand = new Random();
		//long seed = 950000000;
	    rand.setSeed(System.currentTimeMillis());
		String id =  Integer.toString(rand.nextInt(10000));
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		int  age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		
		Customer customer = new Customer(id,username,pass,fname,lname,age,email);
		CustomerDAO dao = new CustomerDAO();
		dao.insertCustomer(customer);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Shopping_Home.html");
		rd.forward(request, response);
		
		
	}

}
