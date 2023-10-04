package com.hmk.system.permission.web.response;

import com.hmk.system.permission.business.domain.Role;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@Builder
public class RoleResponse {

    private Long id;

    private String name;

    private String description;

    public static RoleResponse from(final Role role) {
        return RoleResponse.builder()
                .id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .build();
    }
}
