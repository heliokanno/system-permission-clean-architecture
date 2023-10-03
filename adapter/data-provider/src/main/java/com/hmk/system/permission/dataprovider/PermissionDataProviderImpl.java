package com.hmk.system.permission.dataprovider;

import com.hmk.system.permission.dataprovider.converter.PermissionEntityConverter;
import com.hmk.system.permission.business.domain.Permission;
import com.hmk.system.permission.dataprovider.repository.PermissionRepository;
import com.hmk.system.permission.business.domain.filter.PermissionFilter;
import com.hmk.system.permission.business.port.out.PermissionDataProvider;
import com.hmk.system.permission.business.domain.view.PaginationView;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PermissionDataProviderImpl implements PermissionDataProvider {

    private final PermissionRepository repository;

    @Override
    public Permission save(Permission permission) {
        var permissionEntity = PermissionEntityConverter.from(permission);
        repository.save(permissionEntity);
        return PermissionEntityConverter.to(permissionEntity);
    }

    @Override
    public Optional<Permission> findById(Long id) {
        var permissionEntity = repository.findById(id);
        return permissionEntity.map(PermissionEntityConverter::to);
    }

    @Override
    public PaginationView<Permission> findByFilterPageable(final PermissionFilter filter, final int page, final int size) {
        var pageable = PageRequest.of(page, size, Sort.by("name"));

        var pageView = repository.findAllByNameContains(filter.name(), pageable);

        return PaginationView.<Permission>builder()
                .currentPage(page)
                .totalPages(pageView.getTotalPages())
                .totalItems(pageView.getTotalElements())
                .content(pageView.isEmpty() ? Collections.emptyList() : pageView.getContent()
                        .stream()
                        .map(PermissionEntityConverter::to)
                        .collect(Collectors.toList()))
                .build();
    }

}
