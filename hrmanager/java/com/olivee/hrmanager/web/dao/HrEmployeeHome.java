package com.olivee.hrmanager.web.dao;

// Generated 2012-9-28 17:48:07 by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olivee.hrmanager.web.entity.HrEmployee;

/**
 * Home object for domain model class HrEmployee.
 * @see com.olivee.hrmanager.web.dao.HrEmployee
 * @author Hibernate Tools
 */
@Repository
public class HrEmployeeHome {

	private static final Log log = LogFactory.getLog(HrEmployeeHome.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(HrEmployee transientInstance) {
		log.debug("persisting HrEmployee instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(HrEmployee instance) {
		log.debug("attaching dirty HrEmployee instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(HrEmployee instance) {
		log.debug("attaching clean HrEmployee instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(HrEmployee persistentInstance) {
		log.debug("deleting HrEmployee instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HrEmployee merge(HrEmployee detachedInstance) {
		log.debug("merging HrEmployee instance");
		try {
			HrEmployee result = (HrEmployee) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public HrEmployee findById(java.lang.String id) {
		log.debug("getting HrEmployee instance with id: " + id);
		try {
			HrEmployee instance = (HrEmployee) sessionFactory
					.getCurrentSession().get(
							"com.olivee.hrmanager.web.entity.HrEmployee", id);
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

	public List<HrEmployee> findByExample(HrEmployee instance) {
		log.debug("finding HrEmployee instance by example");
		try {
			List<HrEmployee> results = (List<HrEmployee>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.olivee.hrmanager.web.entity.HrEmployee")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<HrEmployee> findByOrganizationId(String orgid) {
		log.debug("finding HrEmployee by organization id instance by example");
		try {
			com.olivee.hrmanager.web.entity.HrEmployee a = null;
			Criteria criteria = sessionFactory
					.getCurrentSession()
					.createCriteria("com.olivee.hrmanager.web.entity.HrEmployee");
			if(orgid!=null && !orgid.trim().equals(""))
				criteria.add(Restrictions.eq("orgid", orgid));
			List<HrEmployee> results = (List<HrEmployee>) criteria.list();
			log.debug("find by organization id successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by organization id failed", re); 
			throw re;
		}
	}
}
