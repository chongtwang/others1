package hibernate.account;

import java.util.Date;

public class Account {
	
	String ID;
	String firstName;
	String lastName;
	Date creationDate;
	double balance;
	
	public static final String ACCOUNT_TYPE_SAVINGS = "SAVINGS";
	public static final String ACCOUNT_TYPE_CHECKING = "CHECKING";

	public Account( String id, String fname, String lname )
	{
		this.setID(id);
		this.setFirstName(fname);
		this.setLastName(lname);
		
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
