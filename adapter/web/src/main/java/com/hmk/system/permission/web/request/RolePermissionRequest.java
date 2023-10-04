package com.hmk.system.permission.web.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class RolePermissionRequest {

    @NotBlank(message = "Role ID is mandatory")
    private Long roleId;

    @NotBlank(message = "Permission ID is mandatory")
    private Long permissionId;
}
