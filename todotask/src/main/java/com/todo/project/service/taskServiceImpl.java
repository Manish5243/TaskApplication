package com.todo.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.source.util.TaskListener;
import com.todo.project.entity.Task;
import com.todo.project.repository.TaskRepository;


@Service
public class taskServiceImpl implements TaskService, TaskListener {
	
	@Autowired
	private TaskRepository taskRepository;
	
	
	@Override
	public String upsert(List<Task> task) {
		for(Task t : task) {
			taskRepository.save(t);
		}
		return "Sucess";
	}

	
	@Override
	public Task getById(Integer taskId) {
		Optional<Task> findById = taskRepository.findById(taskId);
		
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	
	@Override
	public List<Task> getAllTask() {
		
		return taskRepository.findAll();
		
	}
	
	@Override
	public String deleteById(Integer taskId) {
		if(taskRepository.existsById(taskId)) {
			taskRepository.deleteById(taskId);
			return "Delete success";
		}else {
			return "No record found";
		}
	}

}
