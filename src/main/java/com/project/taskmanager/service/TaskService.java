package com.project.taskmanager.service;

import com.project.taskmanager.model.Task;
import com.project.taskmanager.repository.TaskRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public @Nullable Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        task.setCompleted(false);
        task.setTitle(task.getTitle());
        task.setDescription(task.getDescription());
        return taskRepository.save(task);
    }
}
