package com.hmk.system.permission.dataprovider.converter;

import com.hmk.system.permission.dataprovider.entity.PermissionEntity;
import com.hmk.system.permission.business.domain.Permission;

public class PermissionEntityConverter {

    public static Permission to(PermissionEntity permissionEntity) {
        return Permission.builder()
                .id(permissionEntity.getId())
                .name(permissionEntity.getName())
                .description(permissionEntity.getDescription())
                .build();
    }

    public static PermissionEntity from(Permission permission) {
        return PermissionEntity.builder()
                .id(permission.getId())
                .name(permission.getName())
                .description(permission.getDescription())
                .build();
    }

}
