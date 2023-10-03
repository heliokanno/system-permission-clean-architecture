package com.hmk.system.permission.dataprovider;

import com.hmk.system.permission.dataprovider.converter.RoleEntityConverter;
import com.hmk.system.permission.business.domain.Role;
import com.hmk.system.permission.dataprovider.entity.UserRoleEntity;
import com.hmk.system.permission.dataprovider.entity.pk.UserRolePK;
import com.hmk.system.permission.business.port.out.UserRoleDataProvider;
import com.hmk.system.permission.dataprovider.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRoleDataProviderImpl implements UserRoleDataProvider {

    private final UserRoleRepository repository;

    @Override
    public void save(Long userId, Long roleId) {
        var userRoleEntity = UserRoleEntity.builder()
                .pk(new UserRolePK(userId, roleId))
                .build();
        repository.save(userRoleEntity);
    }

    @Override
    public List<Role> findAllRolesByUserId(Long userId) {
        var roles = repository.findAllRolesByUserId(userId);
        return roles.stream()
                .map(RoleEntityConverter::to)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long userId, Long roleId) {
        var pk = new UserRolePK(userId, roleId);
        repository.deleteById(pk);
    }

}
