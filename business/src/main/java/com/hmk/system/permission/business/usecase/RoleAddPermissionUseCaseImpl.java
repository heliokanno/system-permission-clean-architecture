package com.hmk.system.permission.business.usecase;

import com.hmk.system.permission.business.port.in.RoleAddPermissionUseCase;
import com.hmk.system.permission.business.port.out.RolePermissionDataProvider;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;


@Named
@RequiredArgsConstructor
class RoleAddPermissionUseCaseImpl implements RoleAddPermissionUseCase {

    private final RolePermissionDataProvider rolePermissionDataProvider;

    @Override
    public void execute(Long roleId, Long permissionId) {
        rolePermissionDataProvider.save(roleId, permissionId);
    }
}
