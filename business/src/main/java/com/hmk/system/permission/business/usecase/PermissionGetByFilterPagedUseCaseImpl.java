package com.hmk.system.permission.business.usecase;

import com.hmk.system.permission.business.domain.Permission;
import com.hmk.system.permission.business.domain.filter.PermissionFilter;
import com.hmk.system.permission.business.domain.view.PaginationView;
import com.hmk.system.permission.business.port.in.PermissionGetByFilterPagedUseCase;
import com.hmk.system.permission.business.port.out.PermissionDataProvider;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
class PermissionGetByFilterPagedUseCaseImpl implements PermissionGetByFilterPagedUseCase {

    private final PermissionDataProvider permissionDataProvider;

    @Override
    public PaginationView<Permission> execute(final PermissionFilter filter, final int page, final int size) {
        return permissionDataProvider.findByFilterPageable(filter, page, size);
    }
}
