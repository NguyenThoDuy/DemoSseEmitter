package com.tutorial.Common.utils;

import com.tutorial.Common.model.User;
import com.tutorial.Common.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthUtils {
    private final UserRepository userRepository;
    public User getUserLogin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        System.out.println("email: " + email);
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()) return user.get();
        return new User();
    }

}
