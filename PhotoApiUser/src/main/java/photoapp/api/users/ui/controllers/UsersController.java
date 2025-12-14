package photoapp.api.users.ui.controllers;

import org.springframework.web.bind.annotation.*;
import photoapp.api.users.iu.model.CreateUserRequestModel;

@RestController
@RequestMapping("/users")
public class UsersController {

    @GetMapping
    public String getAllUsers() {
        return "Get all users";
    }

    @PostMapping
    public String createUser(@RequestBody CreateUserRequestModel createUserRequestModel) {
        return "Create user";
    }
}
