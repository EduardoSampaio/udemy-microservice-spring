package photoapp.api.users.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import photoapp.api.users.model.AuthResponseModel;
import photoapp.api.users.model.LoginRequestModel;

public interface AuthService {
    AuthResponseModel authenticate(LoginRequestModel loginRequestModel) throws UsernameNotFoundException;
}
