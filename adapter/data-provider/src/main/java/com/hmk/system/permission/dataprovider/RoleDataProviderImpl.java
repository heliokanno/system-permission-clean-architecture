package com.hmk.system.permission.dataprovider;

import com.hmk.system.permission.dataprovider.converter.RoleEntityConverter;
import com.hmk.system.permission.business.domain.Role;
import com.hmk.system.permission.dataprovider.repository.RoleRepository;
import com.hmk.system.permission.business.domain.filter.RoleFilter;
import com.hmk.system.permission.business.port.out.RoleDataProvider;
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
public class RoleDataProviderImpl implements RoleDataProvider {

    private final RoleRepository repository;

    @Override
    public Role save(Role role) {
        var roleEntity = RoleEntityConverter.from(role);
        repository.save(roleEntity);
        return RoleEntityConverter.to(roleEntity);
    }

    @Override
    public Optional<Role> findById(Long id) {
        var roleEntity = repository.findById(id);
        return roleEntity.map(RoleEntityConverter::to);
    }

    @Override
    public PaginationView<Role> findByFilterPageable(final RoleFilter filter, final int page, final int size) {
        var pageable = PageRequest.of(page, size, Sort.by("name"));

        var pageView = repository.findAllByNameContains(filter.name(), pageable);

        return PaginationView.<Role>builder()
                .currentPage(page)
                .totalPages(pageView.getTotalPages())
                .totalItems(pageView.getTotalElements())
                .content(pageView.isEmpty() ? Collections.emptyList() : pageView.getContent()
                        .stream()
                        .map(RoleEntityConverter::to)
                        .collect(Collectors.toList()))
                .build();
    }
}
