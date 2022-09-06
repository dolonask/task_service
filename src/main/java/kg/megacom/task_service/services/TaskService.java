package kg.megacom.task_service.services;

import kg.megacom.task_service.models.Task;
import kg.megacom.task_service.models.UserTask;

import java.util.List;

public interface TaskService {
    List<Task> findActiveTasks(Long userId);

    Task save(Task task);

    Task findById(Long id);

    UserTask closeTask(Long userId, Long taskId);

}
