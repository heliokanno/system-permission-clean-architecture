package com.hmk.system.permission.web.response;


import com.hmk.system.permission.business.domain.Permission;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@Builder
public class PermissionResponse {

    private Long id;

    private String name;

    private String description;

    public static PermissionResponse from(final Permission permission) {
        return PermissionResponse.builder()
                .id(permission.getId())
                .name(permission.getName())
                .description(permission.getDescription())
                .build();
    }
}
