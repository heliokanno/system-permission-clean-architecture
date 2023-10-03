package com.hmk.system.permission.business.domain;

import com.hmk.system.permission.business.domain.exception.ValidationException;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
@Builder
public class Role {
    private Long id;
    private String name;
    private String description;

    public void selfValidation() {
        if (StringUtils.isBlank(this.name)) {
            throw new ValidationException("Email should not be null");
        }
        if (StringUtils.isBlank(this.description)) {
            throw new ValidationException("Description should not be null");
        }
    }
}
