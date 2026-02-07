package photoapp.api.users.services;

import org.springframework.security.core.Authentication;

public interface TokenService {
    String generateToken(Authentication authentication);
    String getUsername(String token);
    boolean isTokenValid(String token);
}
