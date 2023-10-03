package com.hmk.system.permission.business.port.out;

import com.hmk.system.permission.business.domain.Role;

import java.util.List;

public interface UserRoleDataProvider {

    void save(Long userId, Long roleId);

    List<Role> findAllRolesByUserId(Long userId);

    void delete(Long userId, Long roleId);

}
