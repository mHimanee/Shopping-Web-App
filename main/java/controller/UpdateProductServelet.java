package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDataObject;
import domain.Product;

/**
 * Servlet implementation class UpdateProductServelet
 */
@WebServlet("/updateproduct.do")
public class UpdateProductServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServelet() {
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
		
		String id = request.getParameter("id") ;
		String productname = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int units = Integer.parseInt(request.getParameter("units"));
		String category = request.getParameter("category");
		Product p = new Product(id,productname,price,units,category);
		ProductDataObject pdao = new ProductDataObject();
		pdao.updateProduct(p);
		RequestDispatcher rd = request.getRequestDispatcher("ShowAllProducts.jsp");
		rd.forward(request, response);

	}

}
