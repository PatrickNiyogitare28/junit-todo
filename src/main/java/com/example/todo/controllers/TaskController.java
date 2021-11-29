package com.example.todo.controllers;

import com.example.todo.model.Task;
import com.example.todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping("/api/v1/tasks")

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Task task){
        return taskService.save(task);
    }

    @GetMapping("/api/v1/tasks/all")
    public List<Task> getAll(){
        return taskService.getAll();
    }

    @GetMapping("/api/v1/tasks/{id}")
    public ResponseEntity<?> getOneById(@PathVariable("id") int id){
        return taskService.getOneById(id);
    }
}
