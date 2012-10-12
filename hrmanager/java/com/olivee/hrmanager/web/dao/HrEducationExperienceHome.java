package com.olivee.hrmanager.web.dao;

// Generated 2012-9-28 17:48:07 by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olivee.hrmanager.web.entity.HrAwardWinning;
import com.olivee.hrmanager.web.entity.HrEducationExperience;

/**
 * Home object for domain model class HrEducationExperience.
 * @see com.olivee.hrmanager.web.entity.HrEducationExperience
 * @author Hibernate Tools
 */
@Repository
public class HrEducationExperienceHome {

	private static final Log log = LogFactory
			.getLog(HrEducationExperienceHome.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(HrEducationExperience transientInstance) {
		log.debug("persisting HrEducationExperience instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(HrEducationExperience instance) {
		log.debug("attaching dirty HrEducationExperience instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(HrEducationExperience instance) {
		log.debug("attaching clean HrEducationExperience instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(HrEducationExperience persistentInstance) {
		log.debug("deleting HrEducationExperience instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HrEducationExperience merge(HrEducationExperience detachedInstance) {
		log.debug("merging HrEducationExperience instance");
		try {
			HrEducationExperience result = (HrEducationExperience) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public HrEducationExperience findById(java.lang.String id) {
		log.debug("getting HrEducationExperience instance with id: " + id);
		try {
			HrEducationExperience instance = (HrEducationExperience) sessionFactory
					.getCurrentSession()
					.get("com.olivee.hrmanager.web.entity.HrEducationExperience",
							id);
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

	public List<HrEducationExperience> findByExample(
			HrEducationExperience instance) {
		log.debug("finding HrEducationExperience instance by example");
		try {
			List<HrEducationExperience> results = (List<HrEducationExperience>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.olivee.hrmanager.web.entity.HrEducationExperience")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<HrEducationExperience> findByUserId(String userid) {
		log.debug("finding HrEducationExperience by user id instance by example");
		try {
			if(userid==null || userid.trim().equals("")){
				return new ArrayList<HrEducationExperience>();
			}
			@SuppressWarnings("unchecked")
			List<HrEducationExperience> results = (List<HrEducationExperience>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.olivee.hrmanager.web.entity.HrEducationExperience")
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
