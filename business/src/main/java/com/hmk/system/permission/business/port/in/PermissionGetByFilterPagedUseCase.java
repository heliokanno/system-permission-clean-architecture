package com.hmk.system.permission.business.port.in;

import com.hmk.system.permission.business.domain.Permission;
import com.hmk.system.permission.business.domain.filter.PermissionFilter;
import com.hmk.system.permission.business.domain.view.PaginationView;

public interface PermissionGetByFilterPagedUseCase {
    PaginationView<Permission> execute(final PermissionFilter filter, final int page, final int size);
}
