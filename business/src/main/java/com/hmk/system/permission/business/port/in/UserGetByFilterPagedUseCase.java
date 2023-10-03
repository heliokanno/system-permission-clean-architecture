package com.hmk.system.permission.business.port.in;

import com.hmk.system.permission.business.domain.User;
import com.hmk.system.permission.business.domain.filter.UserFilter;
import com.hmk.system.permission.business.domain.view.PaginationView;

public interface UserGetByFilterPagedUseCase {
    PaginationView<User> execute(final UserFilter filter, final int page, final int size);
}
