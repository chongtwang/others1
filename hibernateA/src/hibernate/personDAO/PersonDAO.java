package hibernate.personDAO;

import java.util.List;

import model.Donation;
import model.Person;

public interface PersonDAO {
	 
    public void save(Person p);
     
    public List<Person> list();
    
    public List<Person> getListLike( String s );

    public List<String> getNameLike( String s );

    public String getNameLikeJason( String s );
    
    public List<Donation> getDonation();
    
    public Person getPerson( String ID );

}