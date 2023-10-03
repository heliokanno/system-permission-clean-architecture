package com.hmk.system.permission.business.port.in;

import com.hmk.system.permission.business.domain.User;

public interface UserUpdateUseCase {
    User execute(final Long userId, final User user);
}
