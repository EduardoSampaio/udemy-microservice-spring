package photoapp.api.users.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String firstName;
    private String lastName;
    private String email;
}
