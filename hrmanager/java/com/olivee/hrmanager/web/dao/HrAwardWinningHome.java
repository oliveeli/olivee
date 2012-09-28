package com.olivee.hrmanager.web.dao;

// Generated 2012-9-28 17:48:07 by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.olivee.hrmanager.web.entity.HrAwardWinning;

/**
 * Home object for domain model class HrAwardWinning.
 * @see com.olivee.hrmanager.web.dao.HrAwardWinning
 * @author Hibernate Tools
 */
public class HrAwardWinningHome {

	private static final Log log = LogFactory.getLog(HrAwardWinningHome.class);

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

	public void persist(HrAwardWinning transientInstance) {
		log.debug("persisting HrAwardWinning instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(HrAwardWinning instance) {
		log.debug("attaching dirty HrAwardWinning instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(HrAwardWinning instance) {
		log.debug("attaching clean HrAwardWinning instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(HrAwardWinning persistentInstance) {
		log.debug("deleting HrAwardWinning instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HrAwardWinning merge(HrAwardWinning detachedInstance) {
		log.debug("merging HrAwardWinning instance");
		try {
			HrAwardWinning result = (HrAwardWinning) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public HrAwardWinning findById(java.lang.String id) {
		log.debug("getting HrAwardWinning instance with id: " + id);
		try {
			HrAwardWinning instance = (HrAwardWinning) sessionFactory
					.getCurrentSession().get(
							"com.olivee.hrmanager.web.dao.HrAwardWinning", id);
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

	public List<HrAwardWinning> findByExample(HrAwardWinning instance) {
		log.debug("finding HrAwardWinning instance by example");
		try {
			List<HrAwardWinning> results = (List<HrAwardWinning>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.olivee.hrmanager.web.dao.HrAwardWinning")
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
