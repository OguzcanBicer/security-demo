package com.oguzcan.securitydemo.utils;

import com.oguzcan.securitydemo.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    public static User getLoggedOnUser() {
        final var auth = SecurityContextHolder.getContext().getAuthentication();
        return (User) auth.getPrincipal();
    }

    public static Long getLoggedOnUserId() {
        return getLoggedOnUser().getId();
    }
}
