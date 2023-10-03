package com.hmk.system.permission.business.port.in;

import com.hmk.system.permission.business.domain.Permission;

import java.util.List;

public interface UserGetAllPermissionsUseCase {
    List<Permission> execute(Long userId);
}
