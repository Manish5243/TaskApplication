package com.todo.project.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String taskName;
	private String taskDescription;
	private boolean taskStatus;
	private Date targetDate;
	private String userName;
	
	@OneToMany(targetEntity = SubTask.class, cascade = CascadeType.ALL)
	@JoinColumn(name="taskSubTask_fk", referencedColumnName = "id")
	private List<SubTask> subTask;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public boolean isTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(boolean taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<SubTask> getSubTask() {
		return subTask;
	}
	public void setSubTask(List<SubTask> subTask) {
		this.subTask = subTask;
	}
	
	
	public Task(int id, String taskName, String taskDescription, boolean taskStatus, Date targetDate, String userName,
			List<SubTask> subTask) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.taskStatus = taskStatus;
		this.targetDate = targetDate;
		this.userName = userName;
		this.subTask = subTask;
	}
	
	
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", taskName=" + taskName + ", taskDescription=" + taskDescription + ", taskStatus="
				+ taskStatus + ", targetDate=" + targetDate + ", userName=" + userName + ", subTask=" + subTask + "]";
	}
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
