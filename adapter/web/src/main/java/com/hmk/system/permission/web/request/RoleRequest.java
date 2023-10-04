package com.hmk.system.permission.web.request;

import com.hmk.system.permission.business.domain.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class RoleRequest {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Description is mandatory")
    private String description;

    public Role to() {
        return Role.builder()
                .name(name)
                .description(description)
                .build();
    }

}
