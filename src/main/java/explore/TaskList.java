package explore;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity; 

@Entity
public class TaskList extends PanacheEntity {
    public String name;
}
