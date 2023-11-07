package com.vladimirhric.blog.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SecurityConstants {
    public static final long JWT_EXPIRATION = 70000;

    @Value("$jwt-secret")
    public static String JWT_SECRET;
}
