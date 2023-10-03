package com.hmk.system.permission.business.port.out;

import com.hmk.system.permission.business.domain.Permission;

import java.util.List;

public interface RolePermissionDataProvider {

    void save(Long roleId, Long permissionId);

    List<Permission> findAllPermissionsByRoleId(Long roleId);

    List<Permission> findAllPermissionsByUserId(Long userId);

    void delete(Long roleId, Long permissionId);

}
