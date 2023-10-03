package com.hmk.system.permission.dataprovider.repository;

import com.hmk.system.permission.business.domain.enumeration.StatusEnum;
import com.hmk.system.permission.dataprovider.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Page<UserEntity> findAllByNameContainsOrEmailContainsOrStatusEquals(final String name, final String email, final StatusEnum status, final Pageable pageable);
}
