package com.hmk.system.permission.business.port.in;

import com.hmk.system.permission.business.domain.User;

public interface UserGetByIdUseCase {
    User execute(final Long userId);
}
