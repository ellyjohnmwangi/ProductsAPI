package com.mwas.microservice.msproducts.config.security;

import com.google.common.collect.Sets;
import java.util.Set;

import static com.mwas.microservice.msproducts.config.security.ApplicationUserPermission.*;

public enum ApplicationUserRoles {
    INVESTOR(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(PRODUCT_READ, PRODUCT_WRITE, INVESTOR_READ, INVESTOR_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(PRODUCT_READ, INVESTOR_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRoles(Set<ApplicationUserPermission> permissions){
        this.permissions = permissions;
    }
    public Set<ApplicationUserPermission> getPermissions(){
        return permissions;
    }
}
