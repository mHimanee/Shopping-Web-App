/**
 * 
 */
package domain;

import java.util.Objects;

/**
 * @author nsingh
 *
 */
public class Product {

	String id;
	String name;
	double price;
	int unitsInStock;
	String category;
	/**
	 * 
	 */
	public Product() {
		super();
	}
	/**
	 * @param id
	 * @param name
	 * @param price
	 * @param unitsInStock
	 * @param category
	 */
	public Product(String id, String name, double price, int unitsInStock, String category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.unitsInStock = unitsInStock;
		this.category = category;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the unitsInStock
	 */
	public int getUnitsInStock() {
		return unitsInStock;
	}
	/**
	 * @param unitsInStock the unitsInStock to set
	 */
	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", unitsInStock=" + unitsInStock
				+ ", category=" + category + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(category, id, name, price, unitsInStock);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& unitsInStock == other.unitsInStock;
	}
}
