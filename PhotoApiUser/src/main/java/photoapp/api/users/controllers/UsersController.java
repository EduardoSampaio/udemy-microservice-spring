package photoapp.api.users.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import photoapp.api.users.services.UsersService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @GetMapping
    public String getAllUsers() {
        return "Get all users";
    }
}
