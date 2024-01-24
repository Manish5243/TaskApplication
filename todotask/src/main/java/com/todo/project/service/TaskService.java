package com.todo.project.service;

import java.util.List;

import com.todo.project.entity.Task;

public interface TaskService {
	
	public String upsert(List<Task> task);
	public Task getById(Integer taskId);
	public List<Task> getAllTask();
	public String deleteById(List<Integer> taskId);
	//public String updateTaskById(Task task, Integer taskId);
}
