package explore.de;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import explore.TaskList;

@Path("/lists")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class TaskListResources {
    
    @POST
    @Transactional
    public TaskList create(TaskList tasklist){
        tasklist.persist();
        return tasklist;
    }

    @GET
    public List<TaskList> list(){
        return TaskList.listAll();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id){

    }
}
