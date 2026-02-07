package photoapp.api.users.services.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import photoapp.api.users.model.AuthResponseModel;
import photoapp.api.users.model.LoginRequestModel;
import photoapp.api.users.services.AuthService;
import photoapp.api.users.services.TokenService;
import photoapp.api.users.services.UsersService;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final TokenService tokenService;
    private final RefreshTokenServiceImpl refreshTokenService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponseModel authenticate(LoginRequestModel loginRequestModel) {
        var authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestModel.getEmail(),
                        loginRequestModel.getPassword()
                )
        );

        String token = tokenService.generateToken(authenticate);
        String refreshToken = refreshTokenService.create(loginRequestModel.getEmail());

        return AuthResponseModel.builder()
                .accessToken(token)
                .refreshToken(refreshToken)
                .build();

    }
}
