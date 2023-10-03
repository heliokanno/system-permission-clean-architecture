package com.hmk.system.permission.business.domain.filter;

import com.hmk.system.permission.business.domain.enumeration.StatusEnum;

public record UserFilter(String name, String email, StatusEnum status) {
}
