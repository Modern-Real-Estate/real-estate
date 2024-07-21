package com.loinguyen1905.realestate.model.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class MyUserDetail extends User {

    private Long id;
    private String fullName;

    public MyUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities , boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, boolean enabled) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}