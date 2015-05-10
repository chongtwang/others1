package hibernate.jar.test;

import hibernate.person.model.Person;
import hibernate.personDAO.PersonDAO;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class SpringHibernateMain {
	 
    public static void main(String[] args) {
 
    	
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
         
        PersonDAO personDAO = context.getBean(PersonDAO.class);
         
        Person person = new Person();
        person.setName("Kevin"); person.setCountry("China");
        
        // check Spring transaction
        boolean b = TransactionSynchronizationManager.isActualTransactionActive();
         
        personDAO.save(person);
//         
//        System.out.println("Person::"+person);
//         
//        List<Person> list = personDAO.list();

        List<String> list = personDAO.getNameLike("G");

        for(String p : list){
            System.out.println("Person List: "+ p);
        }
        
        String s = personDAO.getNameLikeJason("G");
        
        System.out.println(s);

        //close resources
        context.close();    
    }
}