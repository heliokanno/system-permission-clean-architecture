package com.hmk.system.permission.business.usecase;

import com.hmk.system.permission.business.domain.Role;
import com.hmk.system.permission.business.domain.filter.RoleFilter;
import com.hmk.system.permission.business.domain.view.PaginationView;
import com.hmk.system.permission.business.port.in.RoleGetByFilterPagedUseCase;
import com.hmk.system.permission.business.port.out.RoleDataProvider;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
class RoleGetByFilterPagedUseCaseImpl implements RoleGetByFilterPagedUseCase {

    private final RoleDataProvider roleDataProvider;

    @Override
    public PaginationView<Role> execute(final RoleFilter filter, final int page, final int size) {
        return roleDataProvider.findByFilterPageable(filter, page, size);
    }
}
