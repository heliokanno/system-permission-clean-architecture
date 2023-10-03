package com.hmk.system.permission.business.port.in;

import com.hmk.system.permission.business.domain.Role;

import java.util.List;

public interface UserGetAllRolesUseCase {
    List<Role> execute(Long userId);
}
