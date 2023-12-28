package com.hexagonal.tasks.domain.ports.in;

import java.util.List;
import java.util.Optional;

import com.hexagonal.tasks.domain.models.Task;

public interface TaskUseCases {
    Task createTask(Task task);
    Optional<Task> getTaskById(Long id);
    List<Task> getAllTasks();
    Optional<Task> updateTask(Long id, Task updateTask);
    boolean deleteTask(Long id);
}
