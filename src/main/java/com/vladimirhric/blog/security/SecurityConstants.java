package com.vladimirhric.blog.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.core.env.Environment;


@Component
public class SecurityConstants {
    public static final long JWT_EXPIRATION = 70000;
    public static final String JWT_SECRET = "ThzQOdBzozqHcvWvsfMWnXGWwhqsMOghduyasgdDGSYUGDhdsuiah7641789789dysahuidasuidhasui";
}
