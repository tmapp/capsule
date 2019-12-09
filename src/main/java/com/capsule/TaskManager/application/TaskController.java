package com.capsule.TaskManager.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.BadRequestException;

import com.capsule.TaskManager.model.Task;
import com.capsule.TaskManager.service.TaskService;
import com.capsule.TaskManager.util.ApiNames;
import com.capsule.TaskManager.util.StringConstants;

@RestController
@RequestMapping("/task-manager/v1/api/task")
@CrossOrigin(origins = "*")
public class TaskController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TaskService service;
	
	@RequestMapping(value = ApiNames.ADD_TASK_API, method = RequestMethod.POST, produces = StringConstants.APPJSON)
	public ResponseEntity<String> addTask(@RequestBody Task task ) {
		
		try {
			return new ResponseEntity<>(service.addTask(task),HttpStatus.OK);
		} catch (Exception ex) {
			logger.info("===ERROR IN ADD_TASK_API===", ex.getMessage());
			throw new BadRequestException();
		}
	}
	
	@RequestMapping(value = ApiNames.EDIT_TASK_API, method = RequestMethod.POST, produces = StringConstants.APPJSON)
	public ResponseEntity<String> editTask(@RequestBody Task task) {
		try {
			return new ResponseEntity<>(service.editTask(task),HttpStatus.OK);			
		} catch (Exception ex) {
			logger.info("===ERROR IN EDIT_TASK_API===", ex.getMessage());
			throw new BadRequestException();
		}
	}
	
	@RequestMapping(value = ApiNames.DELETE_TASK_API, method = RequestMethod.POST, produces = StringConstants.APPJSON)
	public ResponseEntity<String> deleteTask(@RequestBody Task task) {
		try {
			return new ResponseEntity<>(service.deleteTask(task),HttpStatus.OK);
		} catch (Exception ex) {
			logger.info("===ERROR IN DELETE_TASK_API===", ex.getMessage());
			throw new BadRequestException();
		}
	}
	
	@RequestMapping(value = ApiNames.VIEW_TASK_API, method = RequestMethod.GET, produces = StringConstants.APPJSON)
	public ResponseEntity<String> viewTask(@RequestBody Task task) {
		try {
			return new ResponseEntity<>(service.viewTask(task),HttpStatus.OK);
		} catch (Exception ex) {
			logger.info("===ERROR IN VIEW_TASK_API===", ex.getMessage());
			throw new BadRequestException();
		}
	}
	
	@RequestMapping(value = ApiNames.END_TASK_API, method = RequestMethod.POST, produces = StringConstants.APPJSON)
	public ResponseEntity<String> endTask(@RequestBody Task task) {
		try {
			return new ResponseEntity<>(service.endTask(task),HttpStatus.OK);
		} catch (Exception ex) {
			logger.info("===ERROR IN END_TASK_API===", ex.getMessage());
			throw new BadRequestException();
		}
	}
} 
