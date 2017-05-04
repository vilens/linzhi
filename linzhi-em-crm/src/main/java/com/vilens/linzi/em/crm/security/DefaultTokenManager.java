package com.vilens.linzi.em.crm.security;

import com.vilens.linzi.em.crm.utils.CodecUtil;
import com.vilens.linzi.em.crm.utils.StringUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by vilens on 2017/4/13.
 */
public class DefaultTokenManager implements TokenManager {
    private static Map<String, String> tokenMap = new ConcurrentHashMap<String, String>();

    @Override
    public String createToken(String username) {
        String token = CodecUtil.createUUID();
        tokenMap.put(token, username);
        return token;
    }

    @Override
    public boolean checkToken(String token) {
        return !StringUtil.isEmpty(token) && tokenMap.containsKey(token);
    }
}
