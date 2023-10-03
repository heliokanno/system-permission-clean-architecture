package com.hmk.system.permission.dataprovider.converter;

import com.hmk.system.permission.business.domain.User;
import com.hmk.system.permission.dataprovider.entity.UserEntity;

public class UserEntityConverter {

    public static User to(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .status(userEntity.getStatus())
                .build();
    }

    public static UserEntity from(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .status(user.getStatus())
                .build();
    }

}
