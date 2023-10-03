package com.hmk.system.permission.business.usecase;

import com.hmk.system.permission.business.domain.Role;
import com.hmk.system.permission.business.port.in.UserGetAllRolesUseCase;
import com.hmk.system.permission.business.port.out.UserRoleDataProvider;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Named
@RequiredArgsConstructor
class UserGetAllRolesUseCaseImpl implements UserGetAllRolesUseCase {

    private final UserRoleDataProvider userRoleDataProvider;

    @Override
    public List<Role> execute(Long userId) {
        return userRoleDataProvider.findAllRolesByUserId(userId);
    }
}
