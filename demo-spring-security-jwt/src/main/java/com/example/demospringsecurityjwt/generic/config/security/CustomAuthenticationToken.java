package com.example.demospringsecurityjwt.generic.config.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomAuthenticationToken extends AbstractAuthenticationToken {

    private final String loginId;

    public CustomAuthenticationToken(final String loginId, final Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.loginId = loginId;
    }

    @Override
    public Object getCredentials() {
        throw new IllegalStateException("credential 존재하지 않습니다.");
    }

    @Override
    public Object getPrincipal() {
        return loginId;
    }
}
