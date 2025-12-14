package photoapp.api.users.services;

import photoapp.api.users.iu.model.CreateUserRequestModel;

public interface UsersService {
    void createUser(CreateUserRequestModel createUserRequestModel);
}
