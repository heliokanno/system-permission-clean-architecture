package com.hmk.system.permission.business.port.in;

public interface RoleRemovePermissionUseCase {
    void execute(Long roleId, Long permissionId);
}
