package com.hmk.system.permission.business.port.in;

import com.hmk.system.permission.business.domain.Role;
import com.hmk.system.permission.business.domain.filter.RoleFilter;
import com.hmk.system.permission.business.domain.view.PaginationView;

public interface RoleGetByFilterPagedUseCase {
    PaginationView<Role> execute(final RoleFilter filter, final int page, final int size);
}
