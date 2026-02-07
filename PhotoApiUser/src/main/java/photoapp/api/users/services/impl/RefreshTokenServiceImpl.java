package photoapp.api.users.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import photoapp.api.users.data.entity.RefreshToken;
import photoapp.api.users.data.repository.RefreshTokenRepository;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl {
    private final RefreshTokenRepository repository;

    @Value("${jwt.refresh-expiration}")
    private long refreshExpiration;

    public String create(String username) {

        String newRefreshToken = UUID.randomUUID().toString();

        RefreshToken refreshToken = new RefreshToken(
                newRefreshToken,
                username,
                Instant.now().plusMillis(refreshExpiration)
        );

        repository.save(refreshToken);

        return newRefreshToken;
    }

    public RefreshToken validate(String token) {

        RefreshToken refresh = repository.findById(token)
                .orElseThrow(() -> new RuntimeException("Refresh token inválido"));

        if (refresh.isInvalid()) {
            throw new RuntimeException("Refresh token expirado ou revogado");
        }

        return refresh;
    }

    public void revoke(String token) {
        repository.findById(token).ifPresent(rt -> {
            rt.setRevoked(true);
            repository.save(rt);
        });
    }
}
