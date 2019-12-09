package com.capsule.TaskManager.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class CommonImpl {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public JdbcTemplate dbAccess;
	
	public boolean insertUpdate(String sql, Object... args) {
		try {
			dbAccess.update(sql, args);
			return true;
		} catch (Exception ex) {
			logger.error("===ERROR in running Query : ", ex.getMessage());
		}
		
		return false;
	}

}
