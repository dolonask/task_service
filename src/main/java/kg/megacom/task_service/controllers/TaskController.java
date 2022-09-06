package kg.megacom.task_service.controllers;

import kg.megacom.task_service.models.Task;
import kg.megacom.task_service.models.UserTask;
import kg.megacom.task_service.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/save")
    public Task save(@RequestBody Task task){
        return taskService.save(task);
    }

    @GetMapping("/list")
    public List<Task> findActiveTasks(@RequestParam Long userId){
        return taskService.findActiveTasks(userId);
    }

    @PostMapping("/close")
    public UserTask closeTask(@RequestParam Long userId, @RequestParam Long taskId){
        return taskService.closeTask(userId, taskId);
    }

}
