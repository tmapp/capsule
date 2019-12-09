package com.capsule.TaskManager.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.capsule.TaskManager.model.Task;
import com.capsule.TaskManager.service.CommonImpl;

@Component
public class TaskDAOImpl extends CommonImpl implements TaskDAO {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean addTask(String qry, Task task) {
		boolean isInserted = false;
		try {
			isInserted = insertUpdate(qry, task.getTaskName(), task.getParentTaskId(),
					task.getStartDate(), task.getEndDate(), task.getPriority(),
					task.getId());
		} catch (Exception ex) {
			logger.error("===Error in creating Task Record===", ex.getMessage());		
		}
		return isInserted;
	}

	@Override
	public boolean editTask(String qry, Task task) {
		boolean isUpdated = false;
		try {
			isUpdated = insertUpdate(qry, task.getTaskName(), task.getParentTaskId(),
					task.getStartDate(), task.getEndDate(), task.getPriority(),
					task.getId());
		} catch (Exception ex) {
			logger.error("===Error in updating Task Record===", ex.getMessage());		
		}
		return isUpdated;
	}

	@Override
	public boolean deleteTask(String qry, Task task) {
		boolean isDeleted = false;
		try {
			isDeleted = insertUpdate(qry, task.getId());
		} catch (Exception ex) {
			logger.error("===Error in deleting Task Record===", ex.getMessage());		
		}
		return isDeleted;
	}

	@Override
	public boolean viewTask(String qry, Task task) {
		return false;
	}

	@Override
	public boolean endTask(String qry, Task task) {
		return false;
	}

}
