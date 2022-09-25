package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ProductDataObject;
import domain.Product;

/**
 * Servlet implementation class AddProductServelet
 */
@WebServlet("/add")
public class AddProductServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServelet() {
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
		Random rand = new Random();
		//long seed = 950000000;
	    rand.setSeed(System.currentTimeMillis());
		String id =  Integer.toString(rand.nextInt(100000));
		String productname = request.getParameter("productname");
		double price = Double.parseDouble(request.getParameter("productprice"));
		int units = Integer.parseInt(request.getParameter("units"));
		String category = request.getParameter("category");
		
		
		Product p = new Product(id,productname,price,units,category);
		ProductDataObject pdao = new ProductDataObject();
		
		
		boolean b = pdao.insertProduct(p);
		
		RequestDispatcher rd = request.getRequestDispatcher("addaproduct.html");
		rd.forward(request, response);
		
		
	}

}
