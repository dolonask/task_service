package kg.megacom.task_service.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "tasks")
public class Task {

    @Id
            @GeneratedValue
    Long id;

    String title;
    @JsonFormat(pattern = "dd.MM.yyyy")
    Date startDate;
    @JsonFormat(pattern = "dd.MM.yyyy")
    Date endDate;
    int period;

}
