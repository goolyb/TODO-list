package explore.de;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {

    @POST
    @Transactional
    public Task create(Task task){ // creation of all task and saving them
        task.persist();
        return task;
    }

    @GET
    public List<Task> list(){   // listing of all tasks 
        return Task.listAll();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Boolean delete(@PathParam ("id") Long id){ // deleting by ID
        return Task.deleteById(id);
    }
    @PATCH
    @Transactional
    @Path("/{id}")
    public Task update(@PathParam ("id") Long id, Task task){ // status button
        Task deviceId = Task.findById(id);
        deviceId.completed = !deviceId.completed;
        return deviceId;
    }


}
