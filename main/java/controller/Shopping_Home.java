package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.CustomerDAO;
import dao.ProductDataObject;
import domain.Product;
/**
 * Servlet implementation class Shopping_Home
 */
@WebServlet("/login.do")
public class Shopping_Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Shopping_Home() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		// username extraction from request
		String username = request.getParameter("username");
		String userpass = request.getParameter("pass");
		String isadmin = request.getParameter("admin");

		PrintWriter out = response.getWriter();
		String dbName = "ParthTyagi_DB";
		// DB server name to be used in connection URL
		String serverName = "punv730f.egeng.info";
		// JDBC connection URL
		String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName="
				+ dbName;

		String Table = "";
		String Destination = "";
		if (isadmin == null) {
			Table = "coustomer_";
			Destination = "HomeProductPage.jsp";
		} else {
			Table = "ADMIN";
			Destination = "HomeProduct.html";
		}

		// Query
		String str = "SELECT * FROM " + Table + " WHERE username = ? and pass=?";
		String customerid = "";
		String user_name = "";
		String pass = "";
		String fname = "";
		String lname = "";
		int age = 0;
		String email  = "";
		ArrayList<Product> listt = new ArrayList<Product>();
		ProductDataObject daoo = new ProductDataObject();

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");
			// Statement stmt = con.createStatement();
			// ResultSet rs = stmt.executeQuery(str);

			PreparedStatement stmt = con.prepareStatement(str);
			stmt.setString(1, username);
			stmt.setString(2, userpass);
			ResultSet rs = stmt.executeQuery();

			// out.println("username");
			boolean found = rs.next();
			if (found == true) {
//				out.print("Login Sucessful");
				CustomerDAO dao = new CustomerDAO();
				HttpSession session = request.getSession(); 
				session.setMaxInactiveInterval(3000000);
				session.setAttribute("username",username);
				if(isadmin == null) {
					session.setAttribute("customerid", rs.getString(1));
					session.setAttribute("username_", rs.getString(2));
					session.setAttribute("pass", rs.getString(3));
					session.setAttribute("fname", rs.getString(4));
					session.setAttribute("lname", rs.getString(5));
					session.setAttribute("age", rs.getInt(6));
					session.setAttribute("email", rs.getString(7));
					
					PreparedStatement stmnt = con.prepareStatement("select productid  from cart_id where customerid = ? ");
					stmnt.setString(1,(String)session.getAttribute("customerid"));
					ResultSet bs = stmnt.executeQuery();
					while(bs.next()) {
						listt.add(daoo.getProductById(bs.getString("productid")));
					}
					session.setAttribute("cart", listt);
					
					PreparedStatement mnt = con.prepareStatement("delete from  cart_id where customerid = ?");
					mnt.setString(1,(String)session.getAttribute("customerid"));
					mnt.executeUpdate();
				}
				
				
				
				// TODO fix
//				PreparedStatement stmnt = con.prepareStatement("select productid  from cart_id where customerid = 'testid';");
//				//out.println(rs.getString(1));
//				//stmnt.setString(1,rs.getString(1));
//				//out.println(rs.getString(1));
//				ResultSet bs = stmnt.executeQuery();
//				ArrayList<Product> listt = new ArrayList<Product>();
//				ProductDataObject daoo = new ProductDataObject();
//				while(bs.next()) {
//					listt.add(daoo.getProductById(bs.getString("productid")));
//					out.println(bs.getString("productid"));
//				}
//				out.println(listt);
//				session.setAttribute("cart", listt);
//				// till here
				RequestDispatcher rd = request.getRequestDispatcher(Destination);
				rd.forward(request, response);
			} else {
				out.print("Username or Password is incorrect");
				RequestDispatcher rd = request.getRequestDispatcher("Shopping_Home.html");
				rd.forward(request, response);
				
			}
			con.close();
		} catch (ClassNotFoundException e) {
			out.println(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println(e);
			e.printStackTrace();
		}

		System.out.println("end of the table...");
	}

}
