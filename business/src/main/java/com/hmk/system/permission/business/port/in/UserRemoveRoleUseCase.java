package com.hmk.system.permission.business.port.in;

public interface UserRemoveRoleUseCase {
    void execute(Long userId, Long roleId);
}
