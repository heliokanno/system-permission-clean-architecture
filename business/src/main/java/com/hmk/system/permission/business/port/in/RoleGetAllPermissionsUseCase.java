package com.hmk.system.permission.business.port.in;

import com.hmk.system.permission.business.domain.Permission;

import java.util.List;

public interface RoleGetAllPermissionsUseCase {
    List<Permission> execute(Long roleId);
}
