package photoapp.api.users.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import photoapp.api.users.model.AuthResponseModel;
import photoapp.api.users.model.CreateUserRequestModel;
import photoapp.api.users.model.CreateUserResponseModel;
import photoapp.api.users.model.LoginRequestModel;
import photoapp.api.users.services.AuthService;
import photoapp.api.users.services.UsersService;
import photoapp.api.users.services.impl.RefreshTokenServiceImpl;
import photoapp.api.users.shared.UserDto;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseModel> login(@RequestBody LoginRequestModel loginRequestModel) {
        AuthResponseModel authResponse = authService.authenticate(loginRequestModel);
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> createUser(@RequestBody CreateUserRequestModel createUserRequestModel) {
         var userDto = UserDto.builder()
                .firstName(createUserRequestModel.getFirstName())
                .lastName(createUserRequestModel.getLastName())
                .email(createUserRequestModel.getEmail())
                .password(createUserRequestModel.getPassword())
                .build();

        usersService.createUser(userDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
