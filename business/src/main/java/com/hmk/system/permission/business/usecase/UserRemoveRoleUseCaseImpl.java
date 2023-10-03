package com.hmk.system.permission.business.usecase;

import com.hmk.system.permission.business.port.in.UserRemoveRoleUseCase;
import com.hmk.system.permission.business.port.out.UserRoleDataProvider;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;


@Named
@RequiredArgsConstructor
class UserRemoveRoleUseCaseImpl implements UserRemoveRoleUseCase {

    private final UserRoleDataProvider userRoleDataProvider;

    @Override
    public void execute(Long userId, Long roleId) {
        userRoleDataProvider.delete(userId, roleId);
    }
}
