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
public class UserRolePK implements Serializable {

    @Column(name = "US_ID")
    private Long userId;

    @Column(name = "RO_ID")
    private Long roleId;
}
