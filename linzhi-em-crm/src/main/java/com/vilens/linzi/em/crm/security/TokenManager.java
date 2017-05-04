package com.vilens.linzi.em.crm.security;

/**
 * Created by vilens on 2017/4/13.
 */
public interface TokenManager {
    String createToken(String username);

    boolean checkToken(String token);
}
