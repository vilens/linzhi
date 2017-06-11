package com.vilens.linzi.em.crm.security;

/**
 * Created by vilens on 2017/4/13.
 */
public interface TokenManager {
    static final String DEFAULT_TOKEN_NAME = "X-Token";
    String createToken(String username);

    boolean checkToken(String token);

    boolean removeToken(String token);
}
