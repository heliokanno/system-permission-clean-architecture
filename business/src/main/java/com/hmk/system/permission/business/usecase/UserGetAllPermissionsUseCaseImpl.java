package com.hmk.system.permission.business.usecase;

import com.hmk.system.permission.business.domain.Permission;
import com.hmk.system.permission.business.port.in.UserGetAllPermissionsUseCase;
import com.hmk.system.permission.business.port.out.RolePermissionDataProvider;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Named
@RequiredArgsConstructor
class UserGetAllPermissionsUseCaseImpl implements UserGetAllPermissionsUseCase {

    private final RolePermissionDataProvider rolePermissionDataProvider;

    @Override
    public List<Permission> execute(Long userId) {
        return rolePermissionDataProvider.findAllPermissionsByUserId(userId);
    }
}
