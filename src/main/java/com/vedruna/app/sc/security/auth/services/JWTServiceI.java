package com.vedruna.app.sc.security.auth.services;

import org.springframework.security.core.userdetails.UserDetails;
import com.vedruna.app.sc.model.SecurityUser;

import java.security.Key;
import java.util.Map;

public interface JWTServiceI {

    String getToken(SecurityUser user);

    String getToken(Map<String, Object> extraClaims, SecurityUser user);

    Key getKey();

    String getUsernameFromToken(String token);

    boolean isTokenValid(String token, UserDetails userDetails);
}
