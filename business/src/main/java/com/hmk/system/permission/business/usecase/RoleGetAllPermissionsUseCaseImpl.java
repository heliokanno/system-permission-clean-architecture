package com.hmk.system.permission.business.usecase;

import com.hmk.system.permission.business.domain.Permission;
import com.hmk.system.permission.business.port.in.RoleGetAllPermissionsUseCase;
import com.hmk.system.permission.business.port.out.RolePermissionDataProvider;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Named
@RequiredArgsConstructor
class RoleGetAllPermissionsUseCaseImpl implements RoleGetAllPermissionsUseCase {

    private final RolePermissionDataProvider rolePermissionDataProvider;

    @Override
    public List<Permission> execute(Long roleId) {
        return rolePermissionDataProvider.findAllPermissionsByRoleId(roleId);
    }
}
