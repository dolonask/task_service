package kg.megacom.task_service.services.impl;

import kg.megacom.task_service.models.UserTask;
import kg.megacom.task_service.repositories.UserTaskRepo;
import kg.megacom.task_service.services.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class UserTaskServiceImpl implements UserTaskService {

    @Autowired
    private UserTaskRepo userTaskRepo;


    @Override
    public long countByUserAndTask(long userId, long taskId, int period) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, period * (-1));

        long count = userTaskRepo.countByUserAndTaskAndPeriod(userId, taskId, calendar.getTime());

        return count;
    }

    @Override
    public UserTask closeTask(UserTask userTask) {
        return userTaskRepo.save(userTask);
    }


}
