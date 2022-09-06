package kg.megacom.task_service.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "user_tasks")
public class UserTask {

    @Id
            @GeneratedValue
    Long id;

    @ManyToOne
            @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
            @JoinColumn(name = "task_id")
    Task task;

    Date closeDate;


}
