package photoapp.api.users.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import org.modelmapper.convention.MatchingStrategies;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import photoapp.api.users.data.entity.UserEntity;
import photoapp.api.users.data.repository.UserRepository;
import photoapp.api.users.services.UsersService;
import photoapp.api.users.shared.UserDto;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Override
    public void createUser(UserDto dto) {
        var userEntity = UserEntity.builder()
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .userId(UUID.randomUUID())
                .build();
        userEntity.setEncryptedPassword(encoder.encode(dto.getPassword()));

        userRepository.save(userEntity);

    }
}
