package hibernate.personDAO;

import hibernate.person.model.Person;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.google.gson.Gson;

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
		Gson gson = new Gson();

		String result = gson.toJson(personList);

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
        return result;
    	
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

    @Transactional
    public void save(Person p) {
		// TODO Auto-generated method stub
        boolean b = TransactionSynchronizationManager.isActualTransactionActive();
    	
    	Session session = this.sessionFactory.getCurrentSession();
    	session.save(p);

	}

    public void save2(Person p) {
		// TODO Auto-generated method stub
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();

	}

	public List<Person> list() {
		// TODO Auto-generated method stub
        Session session = this.sessionFactory.openSession();
        List<Person> personList = session.createQuery("from Person").list();
        session.close();
        return personList;
	}

}
