package com.olivee.hrmanager.web.dao;

// Generated 2012-9-28 17:48:07 by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.olivee.hrmanager.web.entity.HrWorkExperience;

/**
 * Home object for domain model class HrWorkExperience.
 * @see com.olivee.hrmanager.web.dao.HrWorkExperience
 * @author Hibernate Tools
 */
public class HrWorkExperienceHome {

	private static final Log log = LogFactory
			.getLog(HrWorkExperienceHome.class);

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

	public void persist(HrWorkExperience transientInstance) {
		log.debug("persisting HrWorkExperience instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(HrWorkExperience instance) {
		log.debug("attaching dirty HrWorkExperience instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(HrWorkExperience instance) {
		log.debug("attaching clean HrWorkExperience instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(HrWorkExperience persistentInstance) {
		log.debug("deleting HrWorkExperience instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HrWorkExperience merge(HrWorkExperience detachedInstance) {
		log.debug("merging HrWorkExperience instance");
		try {
			HrWorkExperience result = (HrWorkExperience) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public HrWorkExperience findById(java.lang.String id) {
		log.debug("getting HrWorkExperience instance with id: " + id);
		try {
			HrWorkExperience instance = (HrWorkExperience) sessionFactory
					.getCurrentSession()
					.get("com.olivee.hrmanager.web.dao.HrWorkExperience", id);
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

	public List<HrWorkExperience> findByExample(HrWorkExperience instance) {
		log.debug("finding HrWorkExperience instance by example");
		try {
			List<HrWorkExperience> results = (List<HrWorkExperience>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.olivee.hrmanager.web.dao.HrWorkExperience")
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
