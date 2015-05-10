package hibernate.controller;

import hibernate.account.Customer;
import hibernate.person.model.Person;
import hibernate.personDAO.PersonDAO;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class AccountController implements Serializable{

	Customer c;
	
	PersonDAO personDAO;

	Person person = null;
	private String name = "Chong";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// AccountController()
	// {
	// person = new Person();
	// person.setId(1);
	// person.setName("Chong");
	// }

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@PostConstruct
	public void init() {
		// Or here, especially if you depend on injected dependencies.
		name = "chong init()";
		c = new Customer();
		Person p = new Person();

	}

	public Person getPersonTest() {
		List<Person> ls = getAccounts();
		if (ls != null) {
			return ls.get(0);
		}
		person = new Person();
		person.setId(1);
		person.setName("Chong Wang");

		return person;

	}

	private List getAccounts() {
		return null;
		
		// cannot call hibernate
//		return personDAO.list();
	}

}