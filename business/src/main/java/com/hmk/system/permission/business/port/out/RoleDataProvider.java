package com.hmk.system.permission.business.port.out;

import com.hmk.system.permission.business.domain.Role;
import com.hmk.system.permission.business.domain.filter.RoleFilter;
import com.hmk.system.permission.business.domain.view.PaginationView;

import java.util.Optional;

public interface RoleDataProvider {

    Role save(Role role);

    Optional<Role> findById(Long id);

    PaginationView<Role> findByFilterPageable(final RoleFilter filter, final int page, final int size);

}
