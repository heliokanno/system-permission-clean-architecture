package com.hmk.system.permission.business.usecase;

import com.hmk.system.permission.business.domain.User;
import com.hmk.system.permission.business.port.in.UserGetByIdUseCase;
import com.hmk.system.permission.business.port.out.UserDataProvider;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
class UserGetByIdUseCaseImpl implements UserGetByIdUseCase {

    private final UserDataProvider userDataProvider;

    @Override
    public User execute(final Long userId) {
        return userDataProvider.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

}
