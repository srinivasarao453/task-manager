package com.project.taskmanager.repository;

import com.project.taskmanager.model.Task;
import org.jspecify.annotations.Nullable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface TaskRepository extends MongoRepository<Task, String> {

    @Nullable List<Task> getByCompleted(Boolean completed);
}
