package com.capsule.TaskManager.dao;

import com.capsule.TaskManager.model.Task;


public interface TaskDAO {
	
	public boolean addTask(String qry, Task task);
	
	public boolean editTask(String qry, Task task);
	
	public boolean deleteTask(String qry, Task task);
	
	public boolean viewTask(String qry, Task task);
	
	public boolean endTask(String qry, Task task);	

}
