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

import com.olivee.hrmanager.web.entity.HrEducationExperience;
import com.olivee.hrmanager.web.entity.HrFamilyMembers;

/**
 * Home object for domain model class HrFamilyMembers.
 * @see com.olivee.hrmanager.web.entity.HrFamilyMembers
 * @author Hibernate Tools
 */
@Repository
public class HrFamilyMembersHome {

	private static final Log log = LogFactory.getLog(HrFamilyMembersHome.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(HrFamilyMembers transientInstance) {
		log.debug("persisting HrFamilyMembers instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(HrFamilyMembers instance) {
		log.debug("attaching dirty HrFamilyMembers instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(HrFamilyMembers instance) {
		log.debug("attaching clean HrFamilyMembers instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(HrFamilyMembers persistentInstance) {
		log.debug("deleting HrFamilyMembers instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HrFamilyMembers merge(HrFamilyMembers detachedInstance) {
		log.debug("merging HrFamilyMembers instance");
		try {
			HrFamilyMembers result = (HrFamilyMembers) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public HrFamilyMembers findById(java.lang.String id) {
		log.debug("getting HrFamilyMembers instance with id: " + id);
		try {
			HrFamilyMembers instance = (HrFamilyMembers) sessionFactory
					.getCurrentSession().get(
							"com.olivee.hrmanager.web.entity.HrFamilyMembers", id);
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

	public List<HrFamilyMembers> findByExample(HrFamilyMembers instance) {
		log.debug("finding HrFamilyMembers instance by example");
		try {
			List<HrFamilyMembers> results = (List<HrFamilyMembers>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.olivee.hrmanager.web.entity.HrFamilyMembers")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<HrFamilyMembers> findByUserId(String userid) {
		log.debug("finding HrFamilyMembers by user id instance by example");
		try {
			if(userid==null || userid.trim().equals("")){
				return new ArrayList<HrFamilyMembers>();
			}
			@SuppressWarnings("unchecked")
			List<HrFamilyMembers> results = (List<HrFamilyMembers>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.olivee.hrmanager.web.entity.HrFamilyMembers")
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
