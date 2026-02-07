package photoapp.api.users.services;

import photoapp.api.users.shared.UserDto;

import java.util.Optional;

public interface UsersService {
    void createUser(UserDto dto);
}
