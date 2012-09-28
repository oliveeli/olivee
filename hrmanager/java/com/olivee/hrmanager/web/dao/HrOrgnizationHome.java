package com.olivee.hrmanager.web.dao;

// Generated 2012-9-28 17:48:07 by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.olivee.hrmanager.web.entity.HrOrgnization;

/**
 * Home object for domain model class HrOrgnization.
 * @see com.olivee.hrmanager.web.dao.HrOrgnization
 * @author Hibernate Tools
 */
public class HrOrgnizationHome {

	private static final Log log = LogFactory.getLog(HrOrgnizationHome.class);

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

	public void persist(HrOrgnization transientInstance) {
		log.debug("persisting HrOrgnization instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(HrOrgnization instance) {
		log.debug("attaching dirty HrOrgnization instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(HrOrgnization instance) {
		log.debug("attaching clean HrOrgnization instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(HrOrgnization persistentInstance) {
		log.debug("deleting HrOrgnization instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HrOrgnization merge(HrOrgnization detachedInstance) {
		log.debug("merging HrOrgnization instance");
		try {
			HrOrgnization result = (HrOrgnization) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public HrOrgnization findById(java.lang.String id) {
		log.debug("getting HrOrgnization instance with id: " + id);
		try {
			HrOrgnization instance = (HrOrgnization) sessionFactory
					.getCurrentSession().get(
							"com.olivee.hrmanager.web.dao.HrOrgnization", id);
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

	public List<HrOrgnization> findByExample(HrOrgnization instance) {
		log.debug("finding HrOrgnization instance by example");
		try {
			List<HrOrgnization> results = (List<HrOrgnization>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.olivee.hrmanager.web.dao.HrOrgnization")
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
