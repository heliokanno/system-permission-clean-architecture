package com.hmk.system.permission.business.port.in;

public interface RoleAddPermissionUseCase {
    void execute(Long roleId, Long permissionId);
}
