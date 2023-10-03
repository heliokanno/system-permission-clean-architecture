package com.hmk.system.permission.dataprovider;

import com.hmk.system.permission.dataprovider.converter.UserEntityConverter;
import com.hmk.system.permission.business.domain.User;
import com.hmk.system.permission.dataprovider.repository.UserRepository;
import com.hmk.system.permission.business.domain.filter.UserFilter;
import com.hmk.system.permission.business.port.out.UserDataProvider;
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
public class UserDataProviderImpl implements UserDataProvider {

    private final UserRepository repository;

    @Override
    public User save(User user) {
        var userEntity = UserEntityConverter.from(user);
        repository.save(userEntity);
        return UserEntityConverter.to(userEntity);
    }

    @Override
    public Optional<User> findById(Long id) {
        var userEntity = repository.findById(id);
        return userEntity.map(UserEntityConverter::to);
    }

    @Override
    public PaginationView<User> findByFilterPageable(final UserFilter filter, final int page, final int size) {
        var pageable = PageRequest.of(page, size, Sort.by("name"));

        var pageView = repository.findAllByNameContainsOrEmailContainsOrStatusEquals(filter.name(), filter.email(), filter.status(), pageable);

        return PaginationView.<User>builder()
                .currentPage(page)
                .totalPages(pageView.getTotalPages())
                .totalItems(pageView.getTotalElements())
                .content(pageView.isEmpty() ? Collections.emptyList() : pageView.getContent()
                        .stream()
                        .map(UserEntityConverter::to)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
