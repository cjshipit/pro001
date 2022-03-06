package com.li.returnJson;

import java.util.List;

/**
 * @Description:
 * @Auther: Li
 * @Version: 1.0
 */
public class Permissions {

    private List<Permission> permissions;

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "permissions=" + permissions +
                '}';
    }



}
