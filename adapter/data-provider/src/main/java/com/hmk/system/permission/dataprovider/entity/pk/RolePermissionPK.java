package com.hmk.system.permission.dataprovider.entity.pk;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePermissionPK implements Serializable {

    @Column(name = "RO_ID")
    private Long roleId;

    @Column(name = "PR_ID")
    private Long permissionId;
}
