package photoapp.api.users.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import photoapp.api.users.data.entity.UserEntity;
import photoapp.api.users.data.repository.UserRepository;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        UserEntity user = repository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Invalid credentials")
                );

        return new User(
                user.getEmail(),
                user.getEncryptedPassword(),
                true, true, true, true,
                new ArrayList<>()
        );
    }
}