package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import domain.Customer;
import dao.CustomerDAO;
/**
 * Servlet implementation class UpdateCustomerDataServelet
 */
@WebServlet("/updatec.do")
public class UpdateCustomerDataServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerDataServelet() {
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
		HttpSession session = request.getSession(false);
		Customer cus = new Customer((String)session.getAttribute("customerid"), request.getParameter("username"),request.getParameter("pass"),request.getParameter("fname"),request.getParameter("lname"), Integer.parseInt(request.getParameter("age")),request.getParameter("email"));
		CustomerDAO dao = new CustomerDAO();
		dao.updateCustomer(cus);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("ViewProfile.jsp");
		rd.forward(request, response);
	}

}
