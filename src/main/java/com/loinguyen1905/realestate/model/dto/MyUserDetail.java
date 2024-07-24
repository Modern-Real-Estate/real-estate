package com.loinguyen1905.realestate.model.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.UUID;

@Getter
@Setter
public class MyUserDetail extends User {
    private UUID id;
    public MyUserDetail(
        UUID id, String username, String password,
        boolean accountNonExpired, boolean credentialsNonExpired,
        Collection<? extends GrantedAuthority> authorities, boolean accountNonLocked, boolean enabled
    ) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
    }
}