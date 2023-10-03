package com.hmk.system.permission.business.port.in;

import com.hmk.system.permission.business.domain.Permission;

public interface PermissionCreateUseCase {
    Permission execute(Permission permission);
}
