package com.hmk.system.permission.business.port.out;

import com.hmk.system.permission.business.domain.Permission;
import com.hmk.system.permission.business.domain.filter.PermissionFilter;
import com.hmk.system.permission.business.domain.view.PaginationView;

import java.util.Optional;

public interface PermissionDataProvider {

    Permission save(Permission permission);

    Optional<Permission> findById(Long id);

    PaginationView<Permission> findByFilterPageable(final PermissionFilter filter, final int page, final int size);

}
