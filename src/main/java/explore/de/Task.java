package explore.de;

import explore.TaskList;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity 
public class Task extends PanacheEntity {

    @ManyToOne 
    public TaskList tasklist;

    public String name;
    public Boolean completed = false;

}