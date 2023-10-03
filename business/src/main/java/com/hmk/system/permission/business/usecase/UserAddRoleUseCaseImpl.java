package com.hmk.system.permission.business.usecase;

import com.hmk.system.permission.business.port.in.UserAddRoleUseCase;
import com.hmk.system.permission.business.port.out.UserRoleDataProvider;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;


@Named
@RequiredArgsConstructor
class UserAddRoleUseCaseImpl implements UserAddRoleUseCase {

    private final UserRoleDataProvider userRoleDataProvider;

    @Override
    public void execute(Long userId, Long roleId) {
        userRoleDataProvider.save(userId, roleId);
    }
}
