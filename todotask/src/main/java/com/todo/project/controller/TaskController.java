package com.todo.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.project.entity.Task;
import com.todo.project.service.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping("/task")
	public ResponseEntity<String> createTask(@RequestBody Task task){
		String status = taskService.upsert(task);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}
	
	@GetMapping("/task/{tasId}")
	public ResponseEntity<Task> getTask(@PathVariable Integer tasId){
		Task task = taskService.getById(tasId);
		return new ResponseEntity<>(task, HttpStatus.OK);
		
	}
	
	@GetMapping("/tasks")
	public ResponseEntity<List<Task>> getAllTasks(){
		List<Task> allTask = taskService.getAllTask();
		return new ResponseEntity<>(allTask, HttpStatus.OK);
	}
	
	@PutMapping("/task")
	public ResponseEntity<String> UpdateTask(@RequestBody Task task){
		String status = taskService.upsert(task);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
//	@PutMapping(path ="/task/{taskId}", consumes = "application/json")
//	public ResponseEntity<String> UpdateTask(@RequestBody Task task, @PathVariable Integer taskId){
//		String status = taskService.updateTaskById(task, taskId);
//		return new ResponseEntity<>(status, HttpStatus.OK);
//	}

	
	@DeleteMapping("/task/{tasId}")
	public ResponseEntity<String> deleteTask(@PathVariable Integer tasId){
		String status = taskService.deleteById(tasId);
		return new ResponseEntity<>(status, HttpStatus.OK);
		
	}

}
