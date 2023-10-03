package com.hmk.system.permission.business.usecase;

import com.hmk.system.permission.business.domain.User;
import com.hmk.system.permission.business.port.in.UserGetByIdUseCase;
import com.hmk.system.permission.business.port.in.UserUpdateUseCase;
import com.hmk.system.permission.business.port.out.UserDataProvider;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
class UserUpdateUseCaseImpl implements UserUpdateUseCase {

    private final UserDataProvider userDataProvider;
    private final UserGetByIdUseCase userGetByIdUseCase;

    @Override
    public User execute(Long userId, User user) {
        user.selfValidation();
        var savedUser = userGetByIdUseCase.execute(userId);
        savedUser.setName(user.getName());
        savedUser.setEmail(user.getEmail());
        savedUser.setStatus(user.getStatus());
        return userDataProvider.save(savedUser);
    }
}
