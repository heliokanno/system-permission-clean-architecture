package com.hmk.system.permission.business.port.in;

import com.hmk.system.permission.business.domain.Role;

public interface RoleUpdateUseCase {
    Role execute(final Long roleId, final Role role);
}
