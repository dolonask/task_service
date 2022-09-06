package kg.megacom.task_service.repositories;

import kg.megacom.task_service.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

    @Query("select u from Task u where current_timestamp between u.startDate and u.endDate")
    List<Task> findAllActiveTasks();
}
