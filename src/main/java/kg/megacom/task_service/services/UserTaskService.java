package kg.megacom.task_service.services;

import kg.megacom.task_service.models.User;
import kg.megacom.task_service.models.UserTask;

public interface UserTaskService {

    long countByUserAndTask(long userId, long taskId, int period);

    UserTask closeTask(UserTask userTask);
}
