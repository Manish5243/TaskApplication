package com.todo.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.todo.project.entity.SubTask;

public interface SubTaskRepository extends JpaRepository<SubTask, Integer>{
	
	@Query(value = "select * from sub_task where taskfk=?1", nativeQuery = true)
	public List<SubTask> findBySubidEquals(int i);
	
	@Modifying
	@Query(value = "update sub_task set taskfk=?2 where subid=?1", nativeQuery = true)
	public void updateFKSubTask(int subTaskId, int taskId);
	
}
