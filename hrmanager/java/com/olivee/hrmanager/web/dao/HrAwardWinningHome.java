package com.olivee.hrmanager.web.dao;

// Generated 2012-9-28 17:48:07 by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olivee.hrmanager.web.entity.HrAwardWinning;
import com.olivee.hrmanager.web.entity.HrEmployee;

/**
 * Home object for domain model class HrAwardWinning.
 * @see com.olivee.hrmanager.web.entity.HrAwardWinning
 * @author Hibernate Tools
 */
@Repository
public class HrAwardWinningHome {

	private static final Log log = LogFactory.getLog(HrAwardWinningHome.class);

	@Autowired
	private SessionFactory sessionFactory;

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
							"com.olivee.hrmanager.web.entity.HrAwardWinning", id);
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
							"com.olivee.hrmanager.web.entity.HrAwardWinning")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<HrAwardWinning> findByUserId(String userid) {
		log.debug("finding HrAwardWinning by user id instance by example");
		try {
			if(userid==null || userid.trim().equals("")){
				return new ArrayList<HrAwardWinning>();
			}
			@SuppressWarnings("unchecked")
			List<HrAwardWinning> results = (List<HrAwardWinning>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.olivee.hrmanager.web.entity.HrAwardWinning")
					.add(Restrictions.eq("employeeid", userid))
					.list();
			log.debug("find by user id successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by user id failed", re); 
			throw re;
		}
	}
}
