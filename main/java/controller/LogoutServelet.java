package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Product;

/**
 * Servlet implementation class LogoutServelet
 */
@WebServlet("/logout.do")
public class LogoutServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubrex
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);//getSession(true/false)
		ArrayList<Product> lt =  (ArrayList<Product>)session.getAttribute("cart");
		if( lt == null || lt.isEmpty() ) {
			if(!session.isNew()) {
				response.setHeader("Cache-Control", "no-cache");
				response.setHeader("Pragma", "no-cache");
				response.setDateHeader("Expires", 0);
				out.println("<h3>"+session.getAttribute("usename")+"have been successfully logged out!!</h3>");
				session.invalidate();
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("Nishadh_Shopping_Home.html");
			rd.forward(request, response);
		}
		else {
		Iterator<Product> it = lt.iterator();
		//JDBC
		String dbName = "ParthTyagi_DB";
		// DB server name to be used in connection URL
		String serverName = "punv730f.egeng.info";
		// JDBC connection URL
		String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName="
				+ dbName;

		String Table = "cart_id";
		// Query
		String str = "insert into " + Table + " values(?,?,?)";
		while(it.hasNext()) {
			Product current = it.next();
			String customer_id = (String)session.getAttribute("customerid");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");
				// Statement stmt = con.createStatement();
				// ResultSet rs = stmt.executeQuery(str);

				PreparedStatement stmt = con.prepareStatement(str);
				stmt.setString(2, current.getId());
				stmt.setString(1, customer_id);
				stmt.setString(3, session.getId());
				stmt.executeUpdate();

				stmt.close();

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

			if(!session.isNew()) {
				response.setHeader("Cache-Control", "no-cache");
				response.setHeader("Pragma", "no-cache");
				response.setDateHeader("Expires", 0);
				out.println("<h3>"+session.getAttribute("usename")+"have been successfully logged out!!</h3>");
				session.invalidate();
			}
			RequestDispatcher rd = request.getRequestDispatcher("Nishadh_Shopping_Home.html");
			rd.forward(request, response);
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
