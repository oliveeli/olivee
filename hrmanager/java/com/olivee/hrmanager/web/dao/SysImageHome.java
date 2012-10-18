package com.olivee.hrmanager.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olivee.hrmanager.web.entity.SysImage;

@Repository
public class SysImageHome {
	
	private static final Log log = LogFactory
			.getLog(SysImageHome.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void persist(final SysImage transientInstance) {
		log.debug("persisting SysImage instance");
		try {
			sessionFactory.getCurrentSession().doWork(new Work(){
				@Override
				public void execute(Connection connection) throws SQLException {
					PreparedStatement stmt = connection.prepareStatement("insert into SYS_IMAGE(id, img_data) values (?, ?)");
					stmt.setString(1, transientInstance.getId());
					stmt.setString(2, transientInstance.getData());
					stmt.execute();
				}
			});
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

}
