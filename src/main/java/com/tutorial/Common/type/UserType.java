package com.tutorial.Common.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserType {
    ADMIN ("ADMIN", "ROLE_ADMIN"),
    USER("USER", "ROLE_USER");

    private final String role;
    private final String fullRole;
}
