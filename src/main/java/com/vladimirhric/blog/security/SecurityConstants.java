package com.vladimirhric.blog.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@PropertySource({
        "classpath:/secret.properties"
})
public class SecurityConstants {
    public static final long JWT_EXPIRATION = 70000;


    // loading secret constant from application.properties
    public static String JWT_SECRET;
    @Value("${jwt.secret}")
    public void setNameStatic(String name){
        SecurityConstants.JWT_SECRET = name;
    }
}
