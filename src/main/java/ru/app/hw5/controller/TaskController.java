package ru.app.hw5.controller;
import org.springframework.web.bind.annotation.*;
import ru.app.hw5.service.TaskService;
import ru.app.hw5.model.Task;
import ru.app.hw5.model.TaskStatus;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/creat")
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.allTasks();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable TaskStatus status){
        return taskService.getTasksByStatus(status);
    }

    @PutMapping("/{id}/{status}")
    public void updateTaskStatus(@PathVariable long id,@PathVariable String status){
        taskService.updateTaskStatus(id,status);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id){
        taskService.deleteTask(id);
    }

}
