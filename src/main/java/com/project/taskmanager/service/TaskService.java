package com.project.taskmanager.service;

import com.project.taskmanager.model.Task;
import com.project.taskmanager.repository.TaskRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public @Nullable Task updateTask(Task task) {
        Optional<Task> updateData = taskRepository.findById(task.getId());
        if(updateData.isPresent()){
            Task task1 = updateData.get();
            task1.setTitle(task.getTitle());
            task1.setDescription(StringUtils.hasLength(task.getDescription()) ? task.getDescription() : task1.getDescription());
            task1.setCompleted(task.getCompleted());
            return taskRepository.save(task1);
        }
        return null;
    }


    public boolean deleteTask(String id) {
         taskRepository.deleteById(id);
         return true;
    }

    public @Nullable List<Task> getTasks(Boolean completed) {
        return taskRepository.getByCompleted(completed);
    }

    public @Nullable String updateFields(String id, Boolean completed) {
        Optional<Task> existingTaskData = taskRepository.findById(id);
        if(existingTaskData.isPresent()) {
            Task task = existingTaskData.get();
            task.setCompleted(completed);
            taskRepository.save(task);
        }

        return "Status Got Updated SuccessFully";
    }
}
