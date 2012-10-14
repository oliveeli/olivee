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

import com.olivee.hrmanager.web.entity.HrFamilyMembers;
import com.olivee.hrmanager.web.entity.HrVocationalCertificate;

/**
 * Home object for domain model class HrVocationalCertificate.
 * @see com.olivee.hrmanager.web.entity.HrVocationalCertificate
 * @author Hibernate Tools
 */
@Repository
public class HrVocationalCertificateHome {

	private static final Log log = LogFactory
			.getLog(HrVocationalCertificateHome.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(HrVocationalCertificate transientInstance) {
		log.debug("persisting HrVocationalCertificate instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(HrVocationalCertificate instance) {
		log.debug("attaching dirty HrVocationalCertificate instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(HrVocationalCertificate instance) {
		log.debug("attaching clean HrVocationalCertificate instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(HrVocationalCertificate persistentInstance) {
		log.debug("deleting HrVocationalCertificate instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HrVocationalCertificate merge(
			HrVocationalCertificate detachedInstance) {
		log.debug("merging HrVocationalCertificate instance");
		try {
			HrVocationalCertificate result = (HrVocationalCertificate) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public HrVocationalCertificate findById(java.lang.String id) {
		log.debug("getting HrVocationalCertificate instance with id: " + id);
		try {
			HrVocationalCertificate instance = (HrVocationalCertificate) sessionFactory
					.getCurrentSession()
					.get("com.olivee.hrmanager.web.entity.HrVocationalCertificate",
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

	public List<HrVocationalCertificate> findByExample(
			HrVocationalCertificate instance) {
		log.debug("finding HrVocationalCertificate instance by example");
		try {
			List<HrVocationalCertificate> results = (List<HrVocationalCertificate>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.olivee.hrmanager.web.entity.HrVocationalCertificate")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<HrVocationalCertificate> findByUserId(String userid) {
		log.debug("finding HrVocationalCertificate by user id instance by example");
		try {
			if(userid==null || userid.trim().equals("")){
				return new ArrayList<HrVocationalCertificate>();
			}
			@SuppressWarnings("unchecked")
			List<HrVocationalCertificate> results = (List<HrVocationalCertificate>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.olivee.hrmanager.web.entity.HrVocationalCertificate")
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
