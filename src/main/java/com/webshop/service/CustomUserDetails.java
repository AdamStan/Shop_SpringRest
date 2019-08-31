package com.webshop.service;

import com.webshop.model.users.Role;
import com.webshop.model.users.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private boolean isEnable;
    private Collection<? extends GrantedAuthority> authoritiies;

    public CustomUserDetails(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.isEnable = user.isEnable();

        List<GrantedAuthority> auths = new ArrayList<>();
        for(Role role : user.getRoles()){
            auths.add(new SimpleGrantedAuthority(role.getRoleName().toLowerCase()));
        }
        authoritiies = auths;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authoritiies;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return isEnable;
    }
}
