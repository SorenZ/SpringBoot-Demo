package com.example.demo.data;

import com.example.demo.models.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Integer> {
    Task findByName(String name);

    List<Task> findAllByCompleted(boolean isCompleted);
    
    void deleteByName(String name);
    
    long countByCompleted(boolean isCompleted);
    
    List<Task> findAllByRateGreaterThanOrderByRate(int rate);
}
