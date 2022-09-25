/**
 * 
 */
package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;

/**
 * @author nsingh
 *
 */
public class ProductDataObject {

	public ProductDataObject() {
	}

	public Product getProductById(String id) {

		String dbName = "Himanee_DB";
		// DB server name to be used in connection URL
		String serverName = "DB_URL";
		// JDBC connection URL
		String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName="
				+ dbName;
		PrintWriter out = new PrintWriter(System.out);

		String Table = "PRODUCT";
		// Query
		String str = "SELECT * FROM " + Table + " WHERE id = ?";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");
			// Statement stmt = con.createStatement();
			// ResultSet rs = stmt.executeQuery(str);

			PreparedStatement stmt = con.prepareStatement(str);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			// out.println("username");

			Product ps = new Product();
			while (rs.next()) {
				ps.setId(id);
				ps.setName(rs.getString(2));
				ps.setPrice(rs.getDouble(3));
				ps.setUnitsInStock(rs.getInt(4));
				ps.setCategory(rs.getString(5));
				return ps;
			}
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
		return null;

	}

	public boolean insertProduct(Product product) {
		String dbName = "Himanee_DB";
		// DB server name to be used in connection URL
		String serverName = "DB_URL";
		// JDBC connection URL
		String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName="
				+ dbName;

		String Table = "PRODUCT";
		// Query
		String str = "insert into " + Table + " values(?,?,?,?,?)";
		PrintWriter out = new PrintWriter(System.out);

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");
			// Statement stmt = con.createStatement();
			// ResultSet rs = stmt.executeQuery(str);

			PreparedStatement stmt = con.prepareStatement(str);
			stmt.setString(1, product.getId());
			stmt.setString(2, product.getName());
			stmt.setDouble(3, product.getPrice());
			stmt.setInt(4, product.getUnitsInStock());
			stmt.setString(5, product.getCategory());
			stmt.executeUpdate();
			
			stmt.close();

			con.close();
			
			return true;
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
		return false;

	}

	/**
	 * @param product
	 * @return boolean
	 */
	public boolean updateProduct(Product product) {
		String dbName = "Himanee_DB";
		// DB server name to be used in connection URL
		String serverName = "DB_URL";
		// JDBC connection URL
		String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName="
				+ dbName;

		String Table = "PRODUCT";
		// Query
		String str = "update " + Table + " set id = ?, name = ?, price = ?, unitsInStock = ?, category = ? WHERE id = ? ";
		PrintWriter out = new PrintWriter(System.out);

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");
			// Statement stmt = con.createStatement();
			// ResultSet rs = stmt.executeQuery(str);

			PreparedStatement stmt = con.prepareStatement(str);
			stmt.setString(1, product.getId());
			stmt.setString(2, product.getName());
			stmt.setDouble(3, product.getPrice());
			stmt.setInt(4, product.getUnitsInStock());
			stmt.setString(5, product.getCategory());
			stmt.setString(6, product.getId());
			stmt.executeUpdate();
			
			stmt.close();

			con.close();
		
			return true;
		} catch (ClassNotFoundException e) {
			out.println(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println(e);
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteProduct(String id) {
		String dbName = "Himanee_DB";
		// DB server name to be used in connection URL
		String serverName = "DB_URL";
		// JDBC connection URL
		String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName="
				+ dbName;

		String Table = "PRODUCT";
		// Query
		String str = "delete from " + Table + " WHERE id = ? ";
		PrintWriter out = new PrintWriter(System.out);

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");
			// Statement stmt = con.createStatement();
			// ResultSet rs = stmt.executeQuery(str);

			PreparedStatement stmt = con.prepareStatement(str);
			stmt.setString(1, id);
			stmt.executeUpdate();
			
			stmt.close();
			

			con.close();
			return true;
		} catch (ClassNotFoundException e) {
			out.println(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println(e);
			e.printStackTrace();
			return false;
		}

	}

	public ArrayList<Product> getAllProducts() {
		String dbName = "Himanee_DB";
		// DB server name to be used in connection URL
		String serverName = "DB_URL";
		// JDBC connection URL
		String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName="
				+ dbName;

		String Table = "PRODUCT";
		// Query
		PrintWriter out = new PrintWriter(System.out);
		ArrayList<Product> productlist = new ArrayList<Product>();

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");
			// Statement stmt = con.createStatement();
			// ResultSet rs = stmt.executeQuery(str);
			String str = "Select * from " + Table;

			PreparedStatement stmt = con.prepareStatement(str);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				int unitsInStock = rs.getInt("unitsInStock");
				String category = rs.getString("category");

				productlist.add(new Product(id, name, price, unitsInStock, category));

				
			}
			stmt.close();
			con.close();
			return productlist;
		} catch (ClassNotFoundException e) {
			out.println(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println(e);
			e.printStackTrace();
			return null;
		}
		// return null;

	}

	public ArrayList<Product> getAllProductsByCategory(String category) {
		String dbName = "Himanee_DB";
		// DB server name to be used in connection URL
		String serverName = "DB_URL";
		// JDBC connection URL
		String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName="
				+ dbName;

		String Table = "PRODUCT";
		// Query
		String str = "Select * from " + Table + " where category = ?";
		PrintWriter out = new PrintWriter(System.out);
		ArrayList<Product> productlist = new ArrayList<Product>();

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");
			// Statement stmt = con.createStatement();
			// ResultSet rs = stmt.executeQuery(str);

			PreparedStatement stmt = con.prepareStatement(str);
			stmt.setString(1, category);
			ResultSet rs = stmt.executeQuery();
			
			
			
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				int unitsInStock = rs.getInt("unitsInStock");
				String Pcategory = rs.getString("category");

				productlist.add(new Product(id, name, price, unitsInStock, Pcategory));

				
			}
			stmt.close();
			con.close();
			return productlist;
		} catch (ClassNotFoundException e) {
			out.println(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println(e);
			e.printStackTrace();
			return null;
		}
		
	}

}
