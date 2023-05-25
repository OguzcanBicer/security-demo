package com.oguzcan.securitydemo.utils;

import com.oguzcan.securitydemo.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;


public class SecurityUtil {

    private static Authentication getAuth() {
        var x = SecurityContextHolder.getContext();
        var x2 = SecurityContextHolder.getContext().getAuthentication();
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static User getLoggedOnUser() {
        return (User) getAuth().getPrincipal();
    }

    public static String getLoggedOnUserUsername() {
        return Objects.nonNull(getAuth()) ? SecurityUtil.getLoggedOnUser().getUsername() : "SYSTEM";
    }

    public static Long getLoggedOnUserId() {
        return getLoggedOnUser().getId();
    }
}
