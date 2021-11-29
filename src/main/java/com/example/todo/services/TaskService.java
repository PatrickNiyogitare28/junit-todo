package com.example.todo.services;

import com.example.todo.model.Task;
import com.example.todo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public ResponseEntity<?> save (Task task){
        if(taskRepository.existsByName(task.getName()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Task exist");
        Task newTask =  taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }

    public List<Task> getAll(){
        return taskRepository.findAll();
    }

    public ResponseEntity<?> getOneById(int id){
        Optional<Task> taskOption = taskRepository.findById(id);
        if(!taskOption.isPresent())
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body({"Task with id ["+id+"] not found");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskOption);
    }
}
