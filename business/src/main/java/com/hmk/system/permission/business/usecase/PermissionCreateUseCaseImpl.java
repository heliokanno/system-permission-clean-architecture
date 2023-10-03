package com.hmk.system.permission.business.usecase;

import com.hmk.system.permission.business.domain.Permission;
import com.hmk.system.permission.business.port.in.PermissionCreateUseCase;
import com.hmk.system.permission.business.port.out.PermissionDataProvider;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;


@Named
@RequiredArgsConstructor
class PermissionCreateUseCaseImpl implements PermissionCreateUseCase {

    private final PermissionDataProvider permissionDataProvider;

    @Override
    public Permission execute(Permission permission) {
        permission.selfValidation();
        return permissionDataProvider.save(permission);
    }

}
