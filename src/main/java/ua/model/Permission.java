package ua.model;

import org.springframework.security.core.userdetails.UserDetailsService;

public enum Permission {
    MANAGER_PERMISSION("all_permissions"),
    USER_PERMISSION("only one permission");
    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
