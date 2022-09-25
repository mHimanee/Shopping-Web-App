package domain;

import java.util.Objects;

public class Order {

	String orderid;
	String customerid;
	String productid;
	int units;
	/**
	 * @param orderid
	 * @param customerid
	 * @param productid
	 * @param units
	 */
	public Order(String orderid, String customerid, String productid, int units) {
		this.orderid = orderid;
		this.customerid = customerid;
		this.productid = productid;
		this.units = units;
	}
	/**
	 * 
	 */
	public Order() {
	}
	/**
	 * @return the orderid
	 */
	public String getOrderid() {
		return orderid;
	}
	/**
	 * @param orderid the orderid to set
	 */
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	/**
	 * @return the customerid
	 */
	public String getCustomerid() {
		return customerid;
	}
	/**
	 * @param customerid the customerid to set
	 */
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	/**
	 * @return the productid
	 */
	public String getProductid() {
		return productid;
	}
	/**
	 * @param productid the productid to set
	 */
	public void setProductid(String productid) {
		this.productid = productid;
	}
	/**
	 * @return the units
	 */
	public int getUnits() {
		return units;
	}
	/**
	 * @param units the units to set
	 */
	public void setUnits(int units) {
		this.units = units;
	}
	@Override
	public int hashCode() {
		return Objects.hash(customerid, orderid, productid, units);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customerid, other.customerid) && Objects.equals(orderid, other.orderid)
				&& Objects.equals(productid, other.productid) && units == other.units;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", customerid=" + customerid + ", productid=" + productid + ", units="
				+ units + "]";
	}
}