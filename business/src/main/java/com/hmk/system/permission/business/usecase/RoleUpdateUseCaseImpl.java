package com.hmk.system.permission.business.usecase;

import com.hmk.system.permission.business.domain.Role;
import com.hmk.system.permission.business.port.in.RoleGetByIdUseCase;
import com.hmk.system.permission.business.port.in.RoleUpdateUseCase;
import com.hmk.system.permission.business.port.out.RoleDataProvider;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
class RoleUpdateUseCaseImpl implements RoleUpdateUseCase {

    private final RoleDataProvider roleDataProvider;
    private final RoleGetByIdUseCase roleGetByIdUseCase;

    @Override
    public Role execute(Long roleId, Role role) {
        role.selfValidation();
        var savedRole = roleGetByIdUseCase.execute(roleId);
        savedRole.setName(role.getName());
        savedRole.setDescription(role.getDescription());
        return roleDataProvider.save(savedRole);
    }
}
