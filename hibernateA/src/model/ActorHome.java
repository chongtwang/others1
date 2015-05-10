package model;
// default package
// Generated Feb 25, 2015 11:58:04 AM by Hibernate Tools 4.3.1

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import org.apache.commons.logging.*;
/**
 * Home object for domain model class Actor.
 * @see .Actor
 * @author Hibernate Tools
 */
public class ActorHome {

	private static final Log log = LogFactory.getLog(ActorHome.class);

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

	public void persist(Actor transientInstance) {
		log.debug("persisting Actor instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Actor instance) {
		log.debug("attaching dirty Actor instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Actor instance) {
		log.debug("attaching clean Actor instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Actor persistentInstance) {
		log.debug("deleting Actor instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Actor merge(Actor detachedInstance) {
		log.debug("merging Actor instance");
		try {
			Actor result = (Actor) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Actor findById(java.lang.Short id) {
		log.debug("getting Actor instance with id: " + id);
		try {
			Actor instance = (Actor) sessionFactory.getCurrentSession().get(
					"Actor", id);
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

	public List<Actor> findByExample(Actor instance) {
		log.debug("finding Actor instance by example");
		try {
			List<Actor> results = (List<Actor>) sessionFactory
					.getCurrentSession().createCriteria("Actor")
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
