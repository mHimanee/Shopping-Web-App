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

import domain.Order;

/**
 * @author nsingh
 *
 */
public class OrderDAO {

	/**
	 * 
	 */
	public OrderDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order getOrderById(String id) {

		String dbName = "Himanee_DB";
		// DB server name to be used in connection URL
		String serverName = "DB_URL";
		// JDBC connection URL
		String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName="
				+ dbName;
		PrintWriter out = new PrintWriter(System.out);

		String Table = "Order_id";
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

			Order ps = new Order();
			while (rs.next()) {
				ps.setOrderid(id);
				ps.setCustomerid(rs.getString(2));
				ps.setProductid(rs.getString(3));
				ps.setUnits(rs.getInt(4));
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

	public boolean insertOrder(Order Order) {
		String dbName = "Himanee_DB";
		// DB server name to be used in connection URL
		String serverName = "DB_URL";
		// JDBC connection URL
		String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName="
				+ dbName;

		String Table = "Order_id";
		// Query
		String str = "insert into " + Table + " values(?,?,?,?)";
		PrintWriter out = new PrintWriter(System.out);

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");
			// Statement stmt = con.createStatement();
			// ResultSet rs = stmt.executeQuery(str);

			PreparedStatement stmt = con.prepareStatement(str);
			stmt.setString(1, Order.getOrderid());
			stmt.setString(2, Order.getCustomerid());
			stmt.setString(3, Order.getProductid());
			stmt.setInt(4, Order.getUnits());
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
	 * @param Order
	 * @return boolean
	 */
	public boolean updateOrder(Order Order) {
		String dbName = "Himanee_DB";
		// DB server name to be used in connection URL
		String serverName = "DB_URL";
		// JDBC connection URL
		String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName="
				+ dbName;

		String Table = "Order_id";
		// Query
		String str = "update " + Table + " set id = ? name = ? price = ? unitsInStock = ? category = ? WHERE id = ? ";
		PrintWriter out = new PrintWriter(System.out);

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");
			// Statement stmt = con.createStatement();
			// ResultSet rs = stmt.executeQuery(str);

			PreparedStatement stmt = con.prepareStatement(str);
			stmt.setString(1, Order.getOrderid());
			stmt.setString(2, Order.getCustomerid());
			stmt.setString(4, Order.getProductid());
			stmt.setInt(3, Order.getUnits());
			stmt.executeUpdate(str);

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

	public boolean deleteOrder(String id) {
		String dbName = "Himanee_DB";
		// DB server name to be used in connection URL
		String serverName = "DB_URL";
		// JDBC connection URL
		String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName="
				+ dbName;

		String Table = "Order_id";
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

	public ArrayList<Order> getAllOrders() {
		String dbName = "Himanee_DB";
		// DB server name to be used in connection URL
		String serverName = "DB_URL";
		// JDBC connection URL
		String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName="
				+ dbName;

		String Table = "Order_id";
		// Query
		PrintWriter out = new PrintWriter(System.out);
		ArrayList<Order> Orderlist = new ArrayList<Order>();

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "egain@123");
			// Statement stmt = con.createStatement();
			// ResultSet rs = stmt.executeQuery(str);
			String str = "Select * from " + Table;

			PreparedStatement stmt = con.prepareStatement(str);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String orderid = rs.getString("orderid");
				String customerid = rs.getString("customerid");
				String productid = rs.getString("productid");
				int units = rs.getInt("units");

				Orderlist.add(new Order(orderid,customerid,productid,units));

			}
			stmt.close();
			con.close();
			return Orderlist;
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

}
