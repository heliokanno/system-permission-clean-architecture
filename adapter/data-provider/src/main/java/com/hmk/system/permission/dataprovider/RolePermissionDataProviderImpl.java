package com.hmk.system.permission.dataprovider;

import com.hmk.system.permission.dataprovider.converter.PermissionEntityConverter;
import com.hmk.system.permission.dataprovider.entity.RolePermissionEntity;
import com.hmk.system.permission.business.domain.Permission;
import com.hmk.system.permission.dataprovider.entity.pk.RolePermissionPK;
import com.hmk.system.permission.business.port.out.RolePermissionDataProvider;
import com.hmk.system.permission.dataprovider.repository.RolePermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RolePermissionDataProviderImpl implements RolePermissionDataProvider {

    private final RolePermissionRepository repository;

    @Override
    public void save(Long roleId, Long permissionId) {
        var rolePermissionEntity = RolePermissionEntity.builder()
                .pk(new RolePermissionPK(roleId, permissionId))
                .build();
        repository.save(rolePermissionEntity);
    }

    @Override
    public List<Permission> findAllPermissionsByRoleId(Long roleId) {
        var permissions = repository.findAllPermissionsByRoleId(roleId);
        return permissions.stream()
                .map(PermissionEntityConverter::to)
                .collect(Collectors.toList());
    }

    @Override
    public List<Permission> findAllPermissionsByUserId(Long userId) {
        var permissions = repository.findAllPermissionsByUserId(userId);
        return permissions.stream()
                .map(PermissionEntityConverter::to)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long roleId, Long permissionId) {
        var pk = new RolePermissionPK(roleId, permissionId);
        repository.deleteById(pk);
    }

}
