package com.hmk.system.permission.business.usecase;

import com.hmk.system.permission.business.port.in.RoleRemovePermissionUseCase;
import com.hmk.system.permission.business.port.out.RolePermissionDataProvider;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;


@Named
@RequiredArgsConstructor
class RoleRemovePermissionUseCaseImpl implements RoleRemovePermissionUseCase {

    private final RolePermissionDataProvider rolePermissionDataProvider;

    @Override
    public void execute(Long roleId, Long permissionId) {
        rolePermissionDataProvider.delete(roleId, permissionId);
    }
}
