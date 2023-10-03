package com.hmk.system.permission.business.usecase;

import com.hmk.system.permission.business.domain.Permission;
import com.hmk.system.permission.business.port.in.PermissionGetByIdUseCase;
import com.hmk.system.permission.business.port.out.PermissionDataProvider;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
class PermissionGetByIdUseCaseImpl implements PermissionGetByIdUseCase {

    private final PermissionDataProvider permissionDataProvider;

    @Override
    public Permission execute(final Long permissionId) {
        return permissionDataProvider.findById(permissionId).orElseThrow(() -> new RuntimeException("Permission not found"));
    }

}
