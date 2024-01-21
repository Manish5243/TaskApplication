package com.todo.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SubTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subid;
	private boolean completedStatus = false;
	private String subTaskDescription;
	
	
	public int getSubid() {
		return subid;
	}
	public void setSubid(int subid) {
		this.subid = subid;
	}
	
	public boolean isCompletedStatus() {
		return completedStatus;
	}
	public void setCompletedStatus(boolean completedStatus) {
		this.completedStatus = completedStatus;
	}
	public String getSubTaskDescription() {
		return subTaskDescription;
	}
	public void setSubTaskDescription(String subTaskDescription) {
		this.subTaskDescription = subTaskDescription;
	}
	
	public SubTask(int subid, boolean completedStatus, String subTaskDescription) {
		super();
		this.subid = subid;
		this.completedStatus = completedStatus;
		this.subTaskDescription = subTaskDescription;
	}
	
	public SubTask() {
		super();
	}
	
	

}
