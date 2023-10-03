package com.hmk.system.permission.dataprovider.repository;

import com.hmk.system.permission.dataprovider.entity.PermissionEntity;
import com.hmk.system.permission.dataprovider.entity.RolePermissionEntity;
import com.hmk.system.permission.dataprovider.entity.pk.RolePermissionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RolePermissionRepository extends JpaRepository<RolePermissionEntity, RolePermissionPK> {

    @Query("SELECT p FROM RolePermissionEntity rp " +
            "JOIN rp.permission p " +
            "WHERE rp.pk.roleId = :roleId ")
    List<PermissionEntity> findAllPermissionsByRoleId(@Param("roleId") Long roleId);

    @Query("SELECT p FROM RolePermissionEntity rp " +
            "JOIN rp.permission p " +
            "WHERE rp.pk.roleId IN ( " +
            "SELECT ur.pk.roleId FROM UserRoleEntity ur " +
            "WHERE ur.pk.userId = :userId ) ")
    List<PermissionEntity> findAllPermissionsByUserId(@Param("userId") Long userId);
}
