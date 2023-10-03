package com.hmk.system.permission.business.port.in;

import com.hmk.system.permission.business.domain.Permission;

public interface PermissionGetByIdUseCase {
    Permission execute(final Long permissionId);
}
