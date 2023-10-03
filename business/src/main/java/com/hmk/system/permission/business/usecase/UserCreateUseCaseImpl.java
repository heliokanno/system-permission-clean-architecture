package com.hmk.system.permission.business.usecase;

import com.hmk.system.permission.business.domain.User;
import com.hmk.system.permission.business.port.in.UserCreateUseCase;
import com.hmk.system.permission.business.port.out.UserDataProvider;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;


@Named
@RequiredArgsConstructor
class UserCreateUseCaseImpl implements UserCreateUseCase {

    private final UserDataProvider userDataProvider;

    @Override
    public User execute(User user) {
        user.selfValidation();
        return userDataProvider.save(user);
    }

}
