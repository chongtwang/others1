package hibernate.personDAO;

import hibernate.person.model.Person;

import java.util.List;

public interface PersonDAO {
	 
    public void save(Person p);

    public void save2(Person p);

    public List<Person> list();
    
    public List<Person> getListLike( String s );

    public List<String> getNameLike( String s );

    public String getNameLikeJason( String s );

}