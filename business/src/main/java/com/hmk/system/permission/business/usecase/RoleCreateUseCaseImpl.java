package com.hmk.system.permission.business.usecase;

import com.hmk.system.permission.business.domain.Role;
import com.hmk.system.permission.business.port.in.RoleCreateUseCase;
import com.hmk.system.permission.business.port.out.RoleDataProvider;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;


@Named
@RequiredArgsConstructor
class RoleCreateUseCaseImpl implements RoleCreateUseCase {

    private final RoleDataProvider roleDataProvider;

    @Override
    public Role execute(Role role) {
        role.selfValidation();
        return roleDataProvider.save(role);
    }

}
