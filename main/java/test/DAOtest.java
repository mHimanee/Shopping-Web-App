package test;

import domain.Order;
import domain.Customer;
import dao.CustomerDAO;

import java.util.ArrayList;

import dao.OrderDAO;

public class DAOtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerDAO dao = new CustomerDAO();
		Customer cus = dao.getCustomerById("customerid");
		System.out.println(cus);
		System.out.println(dao.insertCustomer(cus));
		//System.out.print(dao.deleteCustomer(cus.getCoustomerid()));
		cus.setFname("dev2");
		System.out.println(dao.updateCustomer(cus));
		System.out.println(dao.getAllCustomers());
		
		

	}

}
