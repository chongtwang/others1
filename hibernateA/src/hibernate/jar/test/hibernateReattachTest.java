package hibernate.jar.test;



import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class hibernateReattachTest {
	public static  void mergeCase1() {
//    	Configuration cfg = new Configuration();
////      .addResource("Item.hbm.xml")
////      .addResource("Bid.hbm.xml");
//  	  cfg.configure();  
//  	  ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();  
//  	  SessionFactory sessionFactory=cfg.buildSessionFactory(sr); 
//	    Session session = sessionFactory.openSession();
//	    System.out.println("Fetching the object via get call");
//	    Entity entity1 = (Entity) session.get(Entity.class, 1);        
//	    String data = entity1.getData();
//	    session.close();
//	    System.out.println("data is " + data);
//	    entity1.setData("mergeCase1");
//	    Session newSession = sessionFactory.openSession();
//	    Transaction transaction = newSession.beginTransaction();        
//	    Entity entity2 = (Entity) newSession.get(Entity.class, 1);
//	    System.out.println("The data now loaded from db is " + entity2.getData());
//	    System.out.println("(entity1 == entity2) ? " + (entity1 == entity2));
//	    Entity mergedEntity = (Entity) newSession.merge(entity1);  
//
//	//it searches in pc, finds entity2 merges it with entity1 and returns entity2
//	    System.out.println("(entity1 == mergedEntity) ? " + (mergedEntity == entity1));
//	    System.out.println("(entity2 == mergedEntity) ? " + (mergedEntity == entity2));//entty1 is still detached
//	    transaction.commit(); //will cause an update to occur here
//	    newSession.close();
	}

}
