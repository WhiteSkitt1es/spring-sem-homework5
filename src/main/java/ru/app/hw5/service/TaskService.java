package ru.app.hw5.service;

import org.springframework.stereotype.Service;
import ru.app.hw5.data.TaskRepository;
import ru.app.hw5.model.Task;
import ru.app.hw5.model.TaskStatus;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> allTasks(){
        return taskRepository.getAll();
    }

    public List<Task> getTasksByStatus(TaskStatus taskStatus){
      return   taskRepository.getTasksByStatus(taskStatus);
    }

    public void  updateTaskStatus(long id, String status){

        Task task = taskRepository.findById(id);
        task.setTaskStatus(TaskStatus.statusUpdate(status));
        taskRepository.update(id,task);
    }

    public void deleteTask(long id){
        taskRepository.delete(id);
    }
}
