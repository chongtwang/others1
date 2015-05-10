package chong.test;

import static org.junit.Assert.*;
import hibernate.person.model.Person;
import hibernate.personDAO.PersonDAO;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;


@Transactional(rollbackFor=SQLException.class)
public class SpringHibernateTest{

	@Test    
	public void testApp()
	{
//		String s = null;
	   // assertTrue( true );
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        
        PersonDAO personDAO = context.getBean(PersonDAO.class);
         
        Person person = new Person();
        person.setName("Kevin"); person.setCountry("Transaction");
         
        personDAO.save(person);
//         
//        System.out.println("Person::"+person);
//         
//        List<Person> list = personDAO.list();

        List<String> list = personDAO.getNameLike("G");
        assertTrue( list != null );

        for(String p : list){
            System.out.println("Person List: "+ p);
        }
        
        String s = personDAO.getNameLikeJason("G");
        
        System.out.println(s);

        //close resources
        context.close();    
    }



}