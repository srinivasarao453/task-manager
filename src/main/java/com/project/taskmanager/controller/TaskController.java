package com.project.taskmanager.controller;

import com.project.taskmanager.model.Task;
import com.project.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService ;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @PutMapping
    public ResponseEntity<?> updateTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Boolean> deleteTask(@PathVariable String id ){
        return ResponseEntity.ok(taskService.deleteTask(id));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(@RequestParam(required = true) Boolean completed){
        return ResponseEntity.ok(taskService.getTasks(completed));
    }
    @PatchMapping("/{id}/complete")
    public ResponseEntity<?> updateField(@PathVariable String id,@RequestParam Boolean completed){
        return ResponseEntity.ok(taskService.updateFields(id,completed));
    }

}
