package com.tutorial.Common.service;

import com.tutorial.Common.model.User;
import com.tutorial.Common.repository.UserRepository;
import com.tutorial.Common.type.UserType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public CustomUserDetailsService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            System.out.println("loadUserByUsername = " + userOptional.get());
            User user = userOptional.get();
            List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(UserType.USER.getFullRole());
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    encoder.encode(user.getPassword()), authorities);
        }
        throw new UsernameNotFoundException("User not found with email: " + email);
    }
}

