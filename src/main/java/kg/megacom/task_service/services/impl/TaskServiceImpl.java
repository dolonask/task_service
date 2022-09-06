package kg.megacom.task_service.services.impl;

import kg.megacom.task_service.models.Task;
import kg.megacom.task_service.models.User;
import kg.megacom.task_service.models.UserTask;
import kg.megacom.task_service.repositories.TaskRepo;
import kg.megacom.task_service.services.TaskService;
import kg.megacom.task_service.services.UserService;
import kg.megacom.task_service.services.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private  TaskRepo taskRepo;
    @Autowired
    private  UserTaskService userTaskService;
    @Autowired
    private UserService userService;



    @Override
    public List<Task> findActiveTasks(Long userId) {
        List<Task> tasks = taskRepo.findAllActiveTasks();

        tasks = tasks.stream()
                .filter(x-> userTaskService.countByUserAndTask(userId, x.getId(), x.getPeriod() ) == 0)
                .collect(Collectors.toList());

        return tasks;
    }

    @Override
    public Task save(Task task) {
        return taskRepo.save(task);
    }

    @Override
    public Task findById(Long id) {
        return taskRepo.findById(id).orElseThrow();
    }

    @Override
    public UserTask closeTask(Long userId, Long taskId) {
        User user = userService.findById(userId);
        Task task = findById(taskId);

        UserTask userTask = new UserTask();
        userTask.setUser(user);
        userTask.setTask(task);
        userTask.setCloseDate(new Date());

        userTask = userTaskService.closeTask(userTask);

        return userTask;
    }

}
