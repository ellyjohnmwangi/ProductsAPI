package com.mwas.microservice.msproducts.config.security;

public enum ApplicationUserPermission {
    INVESTOR_READ("investor:read"),
    INVESTOR_WRITE("investor:write"),
    PRODUCT_WRITE("course:write"),
    PRODUCT_READ("product;read");


    private final String Permission;

    ApplicationUserPermission(String permission) {
        Permission = permission;
    }

    public String getPermission() {
        return Permission;
    }
}
