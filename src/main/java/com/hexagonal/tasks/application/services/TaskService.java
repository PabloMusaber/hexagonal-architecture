package com.hexagonal.tasks.application.services;

import com.hexagonal.tasks.domain.models.AdditionalTaskInfo;
import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.in.*;

import java.util.List;
import java.util.Optional;

public class TaskService implements TaskUseCases, GetAdditionalTaksInfoUseCase {

    private final TaskUseCases taskUseCases;
    public final GetAdditionalTaksInfoUseCase getAdditionalTaksInfoUseCase;

    public TaskService(TaskUseCases taskUseCases, GetAdditionalTaksInfoUseCase getAdditionalTaksInfoUseCase) {
        this.taskUseCases = taskUseCases;
        this.getAdditionalTaksInfoUseCase = getAdditionalTaksInfoUseCase;
    }

    @Override
    public Task createTask(Task task) {
        return taskUseCases.createTask(task);
    }

    @Override
    public boolean deleteTask(Long id) {
        return taskUseCases.deleteTask(id);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return getAdditionalTaksInfoUseCase.getAdditionalTaskInfo(id);
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskUseCases.getTaskById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskUseCases.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return taskUseCases.updateTask(id, updateTask);
    }
}
