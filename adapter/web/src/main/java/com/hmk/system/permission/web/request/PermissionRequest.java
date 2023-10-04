package com.hmk.system.permission.web.request;

import com.hmk.system.permission.business.domain.Permission;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class PermissionRequest {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Description is mandatory")
    private String description;

    public Permission to() {
        return Permission.builder()
                .name(name)
                .description(description)
                .build();
    }

}
