package com.project.taskmanager.repository;

import com.project.taskmanager.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TaskRepository extends MongoRepository<Task, Integer> {
}
