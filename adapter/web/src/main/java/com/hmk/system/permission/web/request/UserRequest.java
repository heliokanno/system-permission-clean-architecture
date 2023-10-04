package com.hmk.system.permission.web.request;

import com.hmk.system.permission.business.domain.User;
import com.hmk.system.permission.business.domain.enumeration.StatusEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class UserRequest {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Status is mandatory")
    private StatusEnum status;

    public User to() {
        return User.builder()
                .name(name)
                .email(email)
                .status(status)
                .build();
    }

}
