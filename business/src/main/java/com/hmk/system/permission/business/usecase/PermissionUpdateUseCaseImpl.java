package com.hmk.system.permission.business.usecase;

import com.hmk.system.permission.business.domain.Permission;
import com.hmk.system.permission.business.port.in.PermissionGetByIdUseCase;
import com.hmk.system.permission.business.port.in.PermissionUpdateUseCase;
import com.hmk.system.permission.business.port.out.PermissionDataProvider;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
class PermissionUpdateUseCaseImpl implements PermissionUpdateUseCase {

    private final PermissionDataProvider permissionDataProvider;
    private final PermissionGetByIdUseCase permissionGetByIdUseCase;

    @Override
    public Permission execute(Long permissionId, Permission permission) {
        permission.selfValidation();
        var savedPermission = permissionGetByIdUseCase.execute(permissionId);
        savedPermission.setName(permission.getName());
        savedPermission.setDescription(permission.getDescription());
        return permissionDataProvider.save(savedPermission);
    }
}
