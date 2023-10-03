package com.hmk.system.permission.business.usecase;

import com.hmk.system.permission.business.domain.User;
import com.hmk.system.permission.business.domain.filter.UserFilter;
import com.hmk.system.permission.business.domain.view.PaginationView;
import com.hmk.system.permission.business.port.in.UserGetByFilterPagedUseCase;
import com.hmk.system.permission.business.port.out.UserDataProvider;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
class UserGetByFilterPagedUseCaseImpl implements UserGetByFilterPagedUseCase {

    private final UserDataProvider userDataProvider;

    @Override
    public PaginationView<User> execute(final UserFilter filter, final int page, final int size) {
        return userDataProvider.findByFilterPageable(filter, page, size);
    }
}
