package com.todo.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.project.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
