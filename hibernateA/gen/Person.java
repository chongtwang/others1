// default package
// Generated Feb 25, 2015 3:16:42 PM by Hibernate Tools 4.3.1

/**
 * Person generated by hbm2java
 */
public class Person implements java.io.Serializable {

	private short customerId;
	private String name;
	private String country;

	public Person() {
	}

	public Person(short customerId, String name) {
		this.customerId = customerId;
		this.name = name;
	}

	public Person(short customerId, String name, String country) {
		this.customerId = customerId;
		this.name = name;
		this.country = country;
	}

	public short getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(short customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
