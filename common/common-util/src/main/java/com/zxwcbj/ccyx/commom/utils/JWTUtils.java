package com.zxwcbj.ccyx.commom.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zxwcbj.ccyx.model.acl.Admin;
import org.apache.commons.lang.StringUtils;

import java.util.Calendar;

/**
 * @author admin
 */
public class JWTUtils {

    /**
     * 获取token
     * @param admin user
     * @return token
     */
    public static String getToken(Admin admin) {
        Calendar instance = Calendar.getInstance();
        //默认令牌过期时间7天
        instance.add(Calendar.DATE, 7);

        JWTCreator.Builder builder = JWT.create();
        builder.withClaim("userId", admin.getId())
                .withClaim("username", admin.getUsername());

        return builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(admin.getPassword()));
    }

    /**
     * 验证token合法性 成功返回token
     */
    public static DecodedJWT verify(String token) {
        //获取登录用户真正的密码假如数据库查出来的是123456
        String password = "admin";
        JWTVerifier build = JWT.require(Algorithm.HMAC256(password)).build();
        return build.verify(token);
    }
}
