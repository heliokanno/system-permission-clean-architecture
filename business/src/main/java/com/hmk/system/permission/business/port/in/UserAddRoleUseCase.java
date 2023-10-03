package com.hmk.system.permission.business.port.in;

public interface UserAddRoleUseCase {
    void execute(Long userId, Long roleId);
}
