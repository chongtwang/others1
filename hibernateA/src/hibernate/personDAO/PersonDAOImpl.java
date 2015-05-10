package hibernate.personDAO;

import java.util.List;

import model.Donation;
import model.Person;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

//import com.google.gson.Gson;


public class PersonDAOImpl implements PersonDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public String getNameLikeJason( String s ){
        Session session = this.sessionFactory.openSession();
//        Query query = session.createQuery("from Person");
        
        Criteria criteria = session.createCriteria(Person.class);
//        criteria.add(Restrictions.eq("name", "Gates"));
        criteria.setProjection(Projections.projectionList()
        	      .add(Projections.property("name"), "name"));
        criteria.add(Restrictions.like("name", "%"+s+"%"));
        List<String> personList = criteria.list();
        session.close();
        
        // prepare JSON

//        if( personList != null && personList.size() > 0 )
//        {
//        	String t;
//        	result = "[ ";
//        	int size = personList.size();
//        	for( int i = 0; i < size; i++ )
//        	{
//        		t = personList.get(i);
//        		result = result + "\"" + t + "\"";
//        		if( i == size -1 )
//        		{
//        			result = result + " ";
//        		}
//        		else
//        		{
//        			result = result + ", ";
//        		}
//        		
//        	}
//        	result = result + "]";
//        }
        return null;
    	
    }

    public List<String> getNameLike( String s ){
        Session session = this.sessionFactory.openSession();
//        Query query = session.createQuery("from Person");
        
        Criteria criteria = session.createCriteria(Person.class);
//        criteria.add(Restrictions.eq("name", "Gates"));
        criteria.setProjection(Projections.projectionList()
        	      .add(Projections.property("name"), "name"));
        criteria.add(Restrictions.like("name", "%G%"));
        List<String> personList = criteria.list();
        session.close();
        return personList;
    	
    }

    public List<Person> getListLike( String s ){
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from Person");
        
        Criteria criteria = session.createCriteria(Person.class);
//        criteria.add(Restrictions.eq("name", "Gates"));
        criteria.add(Restrictions.like("name", "%G%"));
        List<Person> personList = criteria.list();
        session.close();
        return personList;
    	
    }

    public void save(Person p) {
		// TODO Auto-generated method stub
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {

        	tx = session.beginTransaction();
        	session.persist(p);
        	tx.commit();
        	session.close();
        }
        catch (Exception e) {
        	   if (tx!=null) tx.rollback();
        	   e.printStackTrace(); 
        }finally {
        	   session.close();
        }
	}

	public List<Person> list() {
		// TODO Auto-generated method stub
        Session session = this.sessionFactory.openSession();
        List<Person> personList = session.createQuery("from Person").list();
        session.close();
        return personList;
	}

	public Person getPerson( String ID ) {
		// TODO Auto-generated method stub
        Session session = this.sessionFactory.openSession();
        List<Person> personList = session.createQuery(" FROM Person d where d.id = " + ID ).list();
        session.close();
        
        if( personList != null && personList.size() > 0 )
        {
        	return personList.get(0);
        }
        return null;
	}

	public List<Donation> getDonation() {
		// TODO Auto-generated method stub
        Session session = this.sessionFactory.openSession();
        List<Donation> personList = session.createQuery(" FROM Donation d where d.customer_id = 1").list();
        session.close();
        return personList;
	}

}
