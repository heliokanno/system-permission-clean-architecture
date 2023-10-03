package com.hmk.system.permission.business.usecase;

import com.hmk.system.permission.business.domain.Role;
import com.hmk.system.permission.business.port.in.RoleGetByIdUseCase;
import com.hmk.system.permission.business.port.out.RoleDataProvider;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
class RoleGetByIdUseCaseImpl implements RoleGetByIdUseCase {

    private final RoleDataProvider roleDataProvider;

    @Override
    public Role execute(final Long roleId) {
        return roleDataProvider.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));
    }

}
