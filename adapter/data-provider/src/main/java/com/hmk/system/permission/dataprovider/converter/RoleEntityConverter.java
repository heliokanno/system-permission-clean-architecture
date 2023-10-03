package com.hmk.system.permission.dataprovider.converter;

import com.hmk.system.permission.dataprovider.entity.RoleEntity;
import com.hmk.system.permission.business.domain.Role;


public class RoleEntityConverter {

    public static Role to(RoleEntity roleEntity) {
        return Role.builder()
                .id(roleEntity.getId())
                .name(roleEntity.getName())
                .description(roleEntity.getDescription())
                .build();
    }

    public static RoleEntity from(Role role) {
        return RoleEntity.builder()
                .id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .build();
    }

}
