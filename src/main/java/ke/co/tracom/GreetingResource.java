package ke.co.tracom;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/chat")
public class GreetingResource {
    @Inject MyAIService myAIService;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(String body)
    {
        return myAIService.chat(body);
    }
}
