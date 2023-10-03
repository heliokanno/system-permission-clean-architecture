package com.hmk.system.permission.business.port.out;

import com.hmk.system.permission.business.domain.User;
import com.hmk.system.permission.business.domain.filter.UserFilter;
import com.hmk.system.permission.business.domain.view.PaginationView;

import java.util.Optional;

public interface UserDataProvider {

    User save(User user);

    Optional<User> findById(Long id);

    PaginationView<User> findByFilterPageable(final UserFilter filter, final int page, final int size);

    void delete(Long id);

}
