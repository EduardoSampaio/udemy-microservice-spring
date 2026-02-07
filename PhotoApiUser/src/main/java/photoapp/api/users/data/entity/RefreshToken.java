package photoapp.api.users.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "refresh_tokens")
public class RefreshToken {

    @Id
    private String token;

    private String username;

    private Instant expiresAt;

    @Setter
    private boolean revoked;

    protected RefreshToken() {}

    public RefreshToken(String token, String username, Instant expiresAt) {
        this.token = token;
        this.username = username;
        this.expiresAt = expiresAt;
        this.revoked = false;
    }

    public boolean isExpired() {
        return expiresAt.isBefore(Instant.now());
    }

    public boolean isInvalid() {
        return revoked || isExpired();
    }

}
