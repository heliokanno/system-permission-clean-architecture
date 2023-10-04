package com.hmk.system.permission.web.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class UserRoleRequest {

    @NotBlank(message = "User ID is mandatory")
    private Long userId;

    @NotBlank(message = "Role ID is mandatory")
    private Long roleId;

}
