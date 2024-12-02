package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;

import java.util.Objects;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx){
        var firstName = ctx.pathParam("firstName");
        var lastName = ctx.pathParam("lastName");
        var email = ctx.pathParam("email");
        var password = ctx.pathParam("password");
        var token = Security.generateToken();
        var user = new User(firstName, lastName, email, password, token);
        UserRepository.save(user);
        ctx.redirect(NamedRoutes.userPath(user.getId()));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id).orElseThrow(() -> new NotFoundResponse("user not found"));
        var token = ctx.cookie("token");
        if(Objects.equals(token, user.getToken())) {
            var page =  new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        }else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }
    }


    // END
}