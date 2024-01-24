package com.todo.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.source.util.TaskListener;
import com.todo.project.entity.SubTask;
import com.todo.project.entity.Task;
import com.todo.project.repository.SubTaskRepository;
import com.todo.project.repository.TaskRepository;

import jakarta.transaction.Transactional;


@Service
public class taskServiceImpl implements TaskService, TaskListener {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private SubTaskRepository subTaskRepository;
	
	
	@Transactional
	@Override
	public String upsert(List<Task> task) {
		for(Task t : task) {
			
			int taskID = t.getId();
			List<SubTask> subtaskId = subTaskRepository.findBySubidEquals(taskID);
			
			taskRepository.save(t);
			
			boolean allTrue;
			if(subtaskId.size()>0) {
				allTrue = true;
			}
			else {
				allTrue = false;
			}
			
			for(SubTask s : subtaskId) {
				System.out.println(s.getSubid()+"+++++++++++++++++++++++++++++++++++++++++++++++++");
				if(s.isCompletedStatus() == false) {
					allTrue = false;
				}
			}
			
			if(allTrue) {
				t.setTaskStatus(allTrue);
				taskRepository.save(t);
			}else {
				t.setTaskStatus(allTrue);
				taskRepository.save(t);
			}
			
			for(SubTask s : subtaskId) {
				System.out.println(s.getSubid()+"+++++++++++++++++++Second++++++++++++++++++++++++++++++"+taskID);
				subTaskRepository.updateFKSubTask(s.getSubid(), taskID);
			}
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
	public String deleteById(List<Integer> taskId) {
		String msg ="";
		for(Integer eachId : taskId) {
			if(taskRepository.existsById(eachId)) {
				taskRepository.deleteById(eachId);
				msg = "Delete success";
			}else {
				msg = "No record found";
			}
		}
		return msg;
	}

}
