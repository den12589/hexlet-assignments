package exercise;

import io.javalin.Javalin;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;

import static io.javalin.rendering.template.TemplateUtil.model;

import io.javalin.rendering.template.JavalinJte;
import org.eclipse.jetty.server.Authentication;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users", ctx -> {
            USERS.sort(Comparator.comparingLong(User::getId));
            var usersPage = new UsersPage(USERS);
            ctx.render("users/index.jte", model("usersPage", usersPage));
        });

        app.get("/users/{id}", ctx ->

        {
            long id = Long.parseLong(ctx.pathParam("id"));
            User user = null;
            for (User tempUser : USERS) {
                if (tempUser.getId() == id) {
                    user = tempUser;
                    break;
                }
            }
            if (Objects.isNull(user))
                throw new NotFoundResponse("User not found");
            var userPage = new UserPage(user);
            ctx.render("users/show.jte", model("userPage", userPage));
        });
        // END

        app.get("/", ctx ->

        {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
