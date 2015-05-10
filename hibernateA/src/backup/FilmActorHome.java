package backup;
// default package
// Generated Feb 25, 2015 11:58:04 AM by Hibernate Tools 4.3.1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class FilmActor.
 * @see .FilmActor
 * @author Hibernate Tools
 */
public class FilmActorHome {

	private static final Log log = LogFactory.getLog(FilmActorHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(FilmActor transientInstance) {
		log.debug("persisting FilmActor instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FilmActor instance) {
		log.debug("attaching dirty FilmActor instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FilmActor instance) {
		log.debug("attaching clean FilmActor instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FilmActor persistentInstance) {
		log.debug("deleting FilmActor instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FilmActor merge(FilmActor detachedInstance) {
		log.debug("merging FilmActor instance");
		try {
			FilmActor result = (FilmActor) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FilmActor findById(FilmActorId id) {
		log.debug("getting FilmActor instance with id: " + id);
		try {
			FilmActor instance = (FilmActor) sessionFactory.getCurrentSession()
					.get("FilmActor", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<FilmActor> findByExample(FilmActor instance) {
		log.debug("finding FilmActor instance by example");
		try {
			List<FilmActor> results = (List<FilmActor>) sessionFactory
					.getCurrentSession().createCriteria("FilmActor")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
