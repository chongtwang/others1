package hibernate.jar.test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import model.Address;
import model.Customer;
import model.CustomerHome;
import model.Donation;
import model.Payment;
import model.Person;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SpringHibernateMain {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		// .addResource("Item.hbm.xml")
		// .addResource("Bid.hbm.xml");
		cfg.configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(
				cfg.getProperties()).buildServiceRegistry();
		SessionFactory sf = cfg.buildSessionFactory(sr);

		testTransactionCurrentSession(sf);
//		testQueryCurrentSession(sf);
//		
//		testQuery(sf);
//		
//		testHibernateTransaction(sf);
//
//		testperson(sf);
//		testcustomer(sf);
//
//		TestAddCustomerPayment(sf);
//		TestAddPersonDonation(sf);

		// session=sf.openSession();
		// List<Donation> ls = getDonation( session, "34" );
	}

	@SuppressWarnings("rawtypes")
	public static void testTransactionCurrentSession(SessionFactory sf) {
		//  binary comparison operators: =, >=, <=, <>, !=, like
		// logical operations and, or, not 
		Transaction tx = null;

		// you have to use beginTransaction()
		Session session = sf.getCurrentSession();
		tx = session.beginTransaction();

		// transaction
		Person p1 = (Person) session.get(Person.class, Short.valueOf("1"));
		p1.setName("changed in db");
		// test show update database
		session.update(p1);
		
		tx.commit();

	}

	@SuppressWarnings("rawtypes")
	public static void testQueryCurrentSession(SessionFactory sf) {
		//  binary comparison operators: =, >=, <=, <>, !=, like
		// logical operations and, or, not 
		Transaction tx = null;




		Session session = sf.getCurrentSession();
		tx = session.beginTransaction();
		

		
		List<Customer> ls = null;
		ls = session.createQuery("from Customer where id=1").list();

		// =
		Query query = session.createQuery("from Customer where id= :id");
		Short s = Short.valueOf("1");
		query.setParameter("id", s );
		ls = query.list();

		// =
		query = session.createQuery("from Customer where firstName = :id");
		query.setParameter("id", "DONNA" );
		ls = query.list();

		// like, and
		query = session.createQuery("from Customer where firstName LIKE :id and lastName like :in");
		query.setParameter("id", "D%" );
		query.setParameter("in", "N%" );
		ls = query.list();
		
		Set payment = ls.get(0).getPayments();

		payment.size(); // value is 32

		// transaction
		Person p1 = (Person) session.get(Person.class, Short.valueOf("1"));
		p1.setName("getCT");
		// test show update database
		session.update(p1);

		// delete test works. but once commit, session is closed.
		// need to open it again
//		Short sht = 110;
//		p1 = (Person)session.get(Person.class, sht);
//		session.delete(p1);

		boolean is = session.isOpen();
		
		tx.commit();

		// prove once commit, transaction is closed
		if( session.isOpen())
		{
			tx = session.beginTransaction();
			p1 = (Person) session.get(Person.class, Short.valueOf("1"));
			p1.setName("can do");
			// test show update database
			session.update(p1);
			tx.commit();
		}

//		// create person
//		tx = session.beginTransaction();
//		p1 = new Person();
//		p1.setName("Jackson");
//		p1.setCountry("Canada");
//		Serializable se = session.save(p1);
//		short sht = p1.getCustomerId();
//		tx.commit();
//
//		// create person
//		tx = session.beginTransaction();
//		p1 = (Person)session.get(Person.class, sht);
////		p1.setName("Jackson");
////		p1.setCountry("Canada");
////		Serializable se = session.save(p1);
//		tx.commit();
////		session.close();

	}

	@SuppressWarnings("unused")
	public static void testHibernateTransaction(SessionFactory sf) {
		Person p1, p2, p3, p4;
		Transaction tx = null;

		// test re-attach
		Session session = sf.openSession();
		p1 = (Person) session.get(Person.class, Short.valueOf("1"));
		session.close();
		p1.setName("Kate");
		// reopen session
		session = sf.openSession();
		tx = session.beginTransaction();
		// test show save as a new one, no re-attach
		session.save(p1);
		tx.commit();
		session.close();

		// test re-attach, test show update database
		session = sf.openSession();
		p1 = (Person) session.get(Person.class, Short.valueOf("1"));
		session.close();
		p1.setName("Kate");
		// reopen session
		session = sf.openSession();
		tx = session.beginTransaction();
		// test show update database
		session.update(p1);
		tx.commit();
		session.close();

		// test re-attach, test flush, no update or insert
		session = sf.openSession();
		p1 = (Person) session.get(Person.class, Short.valueOf("1"));
		session.close();
		p1.setName("flush");
		// reopen session
		session = sf.openSession();
		tx = session.beginTransaction();
		// test flush, no update or insert
		session.flush();
		tx.commit();
		session.close();

		// test re-attach, this update the database
		session = sf.openSession();
		p1 = (Person) session.get(Person.class, Short.valueOf("1"));
		session.close();
		p1.setName("saveorupdate");
		// reopen session
		session = sf.openSession();
		tx = session.beginTransaction();
		// test saveorupdate
		session.saveOrUpdate(p1);
		tx.commit();
		session.close();

		// initial
		session = sf.openSession();
		p2 = (Person) session.get(Person.class, Short.valueOf("1"));
		p2.setName("P0");
		tx = session.beginTransaction();
		session.update(p2);
		tx.commit();
		session.close();

		// test2 update, this update the database
		// reopen session
		session = sf.openSession();
		p2 = (Person) session.get(Person.class, Short.valueOf("1"));
		p2.setName("update");
		tx = session.beginTransaction();
		session.update(p2);
		tx.commit();
		session.close();

		// test merge, this update the database
		session = sf.openSession();
		p3 = (Person) session.get(Person.class, Short.valueOf("1"));
		p3.setName("merge");
		tx = session.beginTransaction();
		session.merge(p3);
		tx.commit();
		session.close();

		// test save, this update the database
		session = sf.openSession();
		p3 = (Person) session.get(Person.class, Short.valueOf("1"));
		p3.setName("save");
		tx = session.beginTransaction();
		session.save(p3);
		tx.commit();
		session.close();

		// test flush, this update the database
		session = sf.openSession();
		p1 = (Person) session.get(Person.class, Short.valueOf("1"));
		p1.setName("flush");
		tx = session.beginTransaction();
		session.flush();
		tx.commit();
		session.close();

		// test persist, this update the database
		session = sf.openSession();
		p1 = (Person) session.get(Person.class, Short.valueOf("1"));
		p1.setName("P11");
		p2 = (Person) session.get(Person.class, Short.valueOf("1"));
		p2.setName("Persist");
		tx = session.beginTransaction();
		session.persist(p2);
		tx.commit();
		session.close();

		// // runtime error: Illegal attempt to associate a collection with two
		// open sessions
		// session = sf.openSession();
		// p3 = (Person) session.get(Person.class, Short.valueOf("1"));
		// p3.setName("save");
		// session = sf.openSession();
		// session.save(p3);
		// tx.commit();
		// session.close();

		// test re-attach, test persist
		// runtime error: detached entity passed to persist: model.Person
		// session = sf.openSession();
		// p1 = (Person) session.get(Person.class, Short.valueOf("1"));
		// session.close();
		// p1.setName("persist");
		// // reopen session
		// session = sf.openSession();
		// tx = session.beginTransaction();
		// // test persist
		// session.persist(p1);
		// tx.commit();
		// session.close();

	}

	@SuppressWarnings("unused")
	public static void testperson(SessionFactory sf) {
		// add person with many donations
		Session session = sf.openSession();

		// test
		Person p = (Person) session.get(Person.class, Short.valueOf("1"));
		Person p2 = (Person) session.load(Person.class, Short.valueOf("1"));
		p.setName("Moore");
		session.saveOrUpdate(p);
		p = (Person) session.get(Person.class, Short.valueOf("35"));

		// List<Person> personList =
		// session.createQuery("from Person where id=1").list();
		List<Person> personList = session.createQuery("from Person").list();

		Set payment = personList.get(0).getDonation();

		payment.size(); // value is 32

		session.close();

	}

	@SuppressWarnings("rawtypes")
	public static void testcustomer(SessionFactory sf) {
		// add person with many donations
		Session session = sf.openSession();
		List<Customer> personList = session.createQuery(
				"from Customer where id=1").list();

		Set payment = personList.get(0).getPayments();

		payment.size(); // value is 32

		session.close();

	}

	@SuppressWarnings("rawtypes")
	public static void testQuery(SessionFactory sf) {
		//  binary comparison operators: =, >=, <=, <>, !=, like
		// logical operations and, or, not 

		Session session = sf.openSession();		
		
		List<Customer> ls = null;
		ls = session.createQuery("from Customer where id=1").list();

		// =
		Query query = session.createQuery("from Customer where id= :id");
		Short s = Short.valueOf("1");
		query.setParameter("id", s );
		ls = query.list();

		// =
		query = session.createQuery("from Customer where firstName = :id");
		query.setParameter("id", "DONNA" );
		ls = query.list();

		// like, and
		query = session.createQuery("from Customer where firstName LIKE :id and lastName like :in");
		query.setParameter("id", "D%" );
		query.setParameter("in", "N%" );
		ls = query.list();
		
		Set payment = ls.get(0).getPayments();

		payment.size(); // value is 32
				

		session.close();

	}

	public static void TestAddCustomerPayment(SessionFactory sf) {
		Session session = sf.openSession();
		// get an address
		List<Address> personList = session.createQuery("from Address").list();
		Customer person = new Customer();
		person.setFirstName("Many");
		person.setLastName("China");
		person.setAddress(personList.get(0));
		Date date = new Date();
		person.setCreateDate(date);
		person.setLastUpdate(date);
		Payment don = new Payment();
		don.setAmount(BigDecimal.valueOf(99.99));
		Payment don2 = new Payment();
		don2.setAmount(BigDecimal.valueOf(199.99));
		person.getPayments().add(don);
		person.getPayments().add(don2);

		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.persist(person);
			tx.commit();
			session.close();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}

	}

	public static void TestAddPersonDonation(SessionFactory sf) {
		Session session = sf.openSession();
		// add person with many donations
		// List<Person> personList = session.createQuery("from Person").list();
		Person person = new Person();
		person.setName("Many");
		person.setCountry("China");
		Donation don = new Donation();
		don.setAmount(BigDecimal.valueOf(99.99));
		don.setPerson(person);
		Donation don2 = new Donation();
		don2.setAmount(BigDecimal.valueOf(199.99));
		don2.setPerson(person);
		person.getDonation().add(don);
		person.getDonation().add(don2);

		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.persist(person);
			tx.commit();
			session.close();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}

	}

	public static List<Donation> getDonation(SessionFactory sf, String ID) {
		Session session = sf.openSession();

		// TODO Auto-generated method stub
		List<Donation> personList = session.createQuery(
				" FROM Donation d where d.customer_id = " + ID).list();
		session.close();
		return personList;
	}

}