/**
 * 
 */
package domain;

import java.util.Objects;

public class Customer {
	String coustomerid;
	String username;
	String pass;
	String fname;
	String lname;
	int age;
	String email;

	/**
	 * @param coustomerid
	 * @param username
	 * @param pass
	 * @param fname
	 * @param lname
	 * @param age
	 * @param email
	 */
	public Customer(String coustomerid, String username, String pass, String fname, String lname, int age,
			String email) {
		this.coustomerid = coustomerid;
		this.username = username;
		this.pass = pass;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.email = email;
	}

	/**
	 * 
	 */
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the coustomerid
	 */
	public String getCoustomerid() {
		return coustomerid;
	}

	/**
	 * @param coustomerid the coustomerid to set
	 */
	public void setCoustomerid(String coustomerid) {
		this.coustomerid = coustomerid;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [coustomerid=" + coustomerid + ", username=" + username + ", pass=" + pass + ", fname=" + fname
				+ ", lname=" + lname + ", age=" + age + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, coustomerid, email, fname, lname, pass, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(age, other.age) && Objects.equals(coustomerid, other.coustomerid)
				&& Objects.equals(email, other.email) && Objects.equals(fname, other.fname)
				&& Objects.equals(lname, other.lname) && Objects.equals(pass, other.pass)
				&& Objects.equals(username, other.username);
	}
}