package com.todo.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.project.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
