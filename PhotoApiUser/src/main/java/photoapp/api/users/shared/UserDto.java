package photoapp.api.users.shared;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class UserDto implements Serializable {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String encryptedPassword;
}
