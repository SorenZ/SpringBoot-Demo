package com.example.demo;

import com.example.demo.models.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {
    private List<Task> tasks = new ArrayList<>();

    public TaskController() {
    }

    @PostMapping(path = "/tasks")
    public void addTask(@RequestBody Task task){
        tasks.add(task);
    }

    @GetMapping(path = "/tasks/{id}")
    public Task getTask(@PathVariable int id){
        return tasks.get(id - 1);
    }

    @GetMapping(path = "/tasks")
    public List<Task> getAllTask(){
        return tasks;
    }
    
    @PostMapping(path = "/bunchTasks", consumes = "application/json")
    public int AddTasks(@RequestBody List<Task> tasks) {
        return tasks.size();
    }
}
