package controller;

import controller.model.User;
import controller.model.services.UserService;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.validation.constraints.Pattern;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/users")
public class UserController {
    @Inject
    private UserService userService;
    @Path("/all")
    @GET
    @Produces("application/json")
    public JsonArray getAll(){
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (User user :userService.getAll()){
            arrayBuilder.add(Json.createObjectBuilder().add("email",user.getEmail()));

        }

        return arrayBuilder.build();
    }
}
