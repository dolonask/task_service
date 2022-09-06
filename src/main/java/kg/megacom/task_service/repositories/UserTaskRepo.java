package kg.megacom.task_service.repositories;

import kg.megacom.task_service.models.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserTaskRepo extends JpaRepository<UserTask, Long> {

    @Query("select count(u) from UserTask u where u.user.id = ?1 and u.task.id = ?2 and ?3 < u.closeDate")
    long countByUserAndTaskAndPeriod(Long userId, Long taskId, Date date);


}
