package photoapp.api.users.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginRequestModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String email;
    private String password;
}
