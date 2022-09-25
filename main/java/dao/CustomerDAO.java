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

import domain.Customer;

/**
 * @author nsingh
 *
 */
public class CustomerDAO {

	/**
	 * 
	 */
	public CustomerDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer getCustomerById(String id) {

		String dbName = "Himanee_DB";
		// DB server name to be used in connection URL
		String serverName = "DB_URL";
		// JDBC connection URL
		String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName="
				+ dbName;
		PrintWriter out = new PrintWriter(System.out);

		String Table = "Coustomer_";
		// Query
		String str = "SELECT * FROM " + Table + " WHERE customerid = ?";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "@123");
			// Statement stmt = con.createStatement();
			// ResultSet rs = stmt.executeQuery(str);

			PreparedStatement stmt = con.prepareStatement(str);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();

			// out.println("username");

			Customer ps = new Customer();
			while (rs.next()) {
				ps.setCoustomerid(id);
				ps.setUsername(rs.getString(2));
				ps.setPass(rs.getString(3));
				ps.setFname(rs.getString(4));
				ps.setLname(rs.getString(5));
				ps.setAge(rs.getInt(6));;
				ps.setEmail(rs.getString(7));
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

	public boolean insertCustomer(Customer Customer) {
		String dbName = "Himanee_DB";
		// DB server name to be used in connection URL
		String serverName = "DB_URL";
		// JDBC connection URL
		String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName="
				+ dbName;

		String Table = "Coustomer_";
		// Query
		String str = "insert into " + Table + " values(?,?,?,?,?,?,?)";
		PrintWriter out = new PrintWriter(System.out);

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "@123");
			// Statement stmt = con.createStatement();
			// ResultSet rs = stmt.executeQuery(str);

			PreparedStatement stmt = con.prepareStatement(str);
			stmt.setString(1, Customer.getCoustomerid());
			stmt.setString(2, Customer.getUsername());
			stmt.setString(3, Customer.getPass());
			stmt.setString(4, Customer.getFname());
			stmt.setString(5, Customer.getLname());
			stmt.setInt(6,Customer.getAge());
			stmt.setString(7, Customer.getEmail());
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
	 * @param Customer
	 * @return boolean
	 */
	public boolean updateCustomer(Customer Customer) {
		String dbName = "Himanee_DB";
		// DB server name to be used in connection URL
		String serverName = "DB_URL";
		// JDBC connection URL
		String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName="
				+ dbName;

		String Table = "Coustomer_";
		// Query
		String str = "update " + Table + " set customerid = ?, username = ?, pass = ?, fname = ?, lname = ?, age = ?, email_id = ? WHERE customerid = ? ";
		PrintWriter out = new PrintWriter(System.out);

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "@123");
			// Statement stmt = con.createStatement();
			// ResultSet rs = stmt.executeQuery(str);

			PreparedStatement stmt = con.prepareStatement(str);
			stmt.setString(1, Customer.getCoustomerid());
			stmt.setString(2, Customer.getUsername());
			stmt.setString(3, Customer.getPass());
			stmt.setString(4, Customer.getFname());
			stmt.setString(5, Customer.getLname());
			stmt.setInt(6,Customer.getAge());
			stmt.setString(7, Customer.getEmail());
			stmt.setString(8, Customer.getCoustomerid());
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

	public boolean deleteCustomer(String id) {
		String dbName = "Himanee_DB";
		// DB server name to be used in connection URL
		String serverName = "DB_URL";
		// JDBC connection URL
		String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName="
				+ dbName;

		String Table = "Coustomer_";
		// Query
		String str = "delete from " + Table + " WHERE customerid = ? ";
		PrintWriter out = new PrintWriter(System.out);

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "@123");
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
	
	

	public ArrayList<Customer> getAllCustomers() {
		String dbName = "Himanee_DB";
		// DB server name to be used in connection URL
		String serverName = "DB_URL";
		// JDBC connection URL
		String connectionURL = "jdbc:sqlserver://" + serverName + ":1433;integratedSecurity=false;databaseName="
				+ dbName;

		String Table = "Coustomer_";
		// Query
		PrintWriter out = new PrintWriter(System.out);
		ArrayList<Customer> Customerlist = new ArrayList<Customer>();

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionURL, "sa", "@123");
			// Statement stmt = con.createStatement();
			// ResultSet rs = stmt.executeQuery(str);
			String str = "Select * from " + Table;

			PreparedStatement stmt = con.prepareStatement(str);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Customer ps = new Customer();
				ps.setCoustomerid(rs.getString(1));
				ps.setUsername(rs.getString(2));
				ps.setPass(rs.getString(3));
				ps.setFname(rs.getString(4));
				ps.setLname(rs.getString(5));
				ps.setAge(rs.getInt(6));;
				ps.setEmail(rs.getString(7));
				Customerlist.add(ps);

			}
			stmt.close();
			con.close();
			return Customerlist;
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
