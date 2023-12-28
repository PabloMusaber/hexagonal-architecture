package com.hexagonal.tasks.application.usecases;

import java.util.List;
import java.util.Optional;

import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.in.TaskUseCases;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;

public class TaskUseCasesImpl implements TaskUseCases{

    private final TaskRepositoryPort taskRepositoryPort;

    public TaskUseCasesImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepositoryPort.findAll();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return taskRepositoryPort.update(id, updateTask);
    }

    @Override
    public boolean deleteTask(Long id) {
        return taskRepositoryPort.deleteById(id);
    }

}
