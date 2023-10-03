package com.hmk.system.permission.business.port.in;


import com.hmk.system.permission.business.domain.Role;

public interface RoleCreateUseCase {
    Role execute(final Role role);
}
