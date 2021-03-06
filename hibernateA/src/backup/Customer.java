package backup;
// default package
// Generated Feb 25, 2015 11:58:03 AM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Customer generated by hbm2java
 */
public class Customer implements java.io.Serializable {

	private Short customerId;
	private Address address;
	private byte storeId;
	private String firstName;
	private String lastName;
	private String email;
	private boolean active;
	private Date createDate;
	private Date lastUpdate;
	private String type;
	private Double balace;
	private Set<Rental> rentals = new HashSet<Rental>(0);
	private Set<Payment> payments = new HashSet<Payment>(0);

	public Customer() {
	}

	public Customer(Address address, byte storeId, String firstName,
			String lastName, boolean active, Date createDate, Date lastUpdate) {
		this.address = address;
		this.storeId = storeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.active = active;
		this.createDate = createDate;
		this.lastUpdate = lastUpdate;
	}

	public Customer(Address address, byte storeId, String firstName,
			String lastName, String email, boolean active, Date createDate,
			Date lastUpdate, String type, Double balace, Set<Rental> rentals,
			Set<Payment> payments) {
		this.address = address;
		this.storeId = storeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.active = active;
		this.createDate = createDate;
		this.lastUpdate = lastUpdate;
		this.type = type;
		this.balace = balace;
		this.rentals = rentals;
		this.payments = payments;
	}

	public Short getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Short customerId) {
		this.customerId = customerId;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public byte getStoreId() {
		return this.storeId;
	}

	public void setStoreId(byte storeId) {
		this.storeId = storeId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getBalace() {
		return this.balace;
	}

	public void setBalace(Double balace) {
		this.balace = balace;
	}

	public Set<Rental> getRentals() {
		return this.rentals;
	}

	public void setRentals(Set<Rental> rentals) {
		this.rentals = rentals;
	}

	public Set<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

}
