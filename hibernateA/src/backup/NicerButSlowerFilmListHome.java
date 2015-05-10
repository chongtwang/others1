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
 * Home object for domain model class NicerButSlowerFilmList.
 * @see .NicerButSlowerFilmList
 * @author Hibernate Tools
 */
public class NicerButSlowerFilmListHome {

	private static final Log log = LogFactory
			.getLog(NicerButSlowerFilmListHome.class);

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

	public void persist(NicerButSlowerFilmList transientInstance) {
		log.debug("persisting NicerButSlowerFilmList instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(NicerButSlowerFilmList instance) {
		log.debug("attaching dirty NicerButSlowerFilmList instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NicerButSlowerFilmList instance) {
		log.debug("attaching clean NicerButSlowerFilmList instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(NicerButSlowerFilmList persistentInstance) {
		log.debug("deleting NicerButSlowerFilmList instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NicerButSlowerFilmList merge(NicerButSlowerFilmList detachedInstance) {
		log.debug("merging NicerButSlowerFilmList instance");
		try {
			NicerButSlowerFilmList result = (NicerButSlowerFilmList) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public NicerButSlowerFilmList findById(NicerButSlowerFilmListId id) {
		log.debug("getting NicerButSlowerFilmList instance with id: " + id);
		try {
			NicerButSlowerFilmList instance = (NicerButSlowerFilmList) sessionFactory
					.getCurrentSession().get("NicerButSlowerFilmList", id);
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

	public List<NicerButSlowerFilmList> findByExample(
			NicerButSlowerFilmList instance) {
		log.debug("finding NicerButSlowerFilmList instance by example");
		try {
			List<NicerButSlowerFilmList> results = (List<NicerButSlowerFilmList>) sessionFactory
					.getCurrentSession()
					.createCriteria("NicerButSlowerFilmList")
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
