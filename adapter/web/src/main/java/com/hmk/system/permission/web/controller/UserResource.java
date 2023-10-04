package com.hmk.system.permission.web.controller;


import com.hmk.system.permission.business.domain.enumeration.StatusEnum;
import com.hmk.system.permission.business.domain.filter.UserFilter;
import com.hmk.system.permission.business.domain.view.PaginationView;
import com.hmk.system.permission.business.port.in.UserAddRoleUseCase;
import com.hmk.system.permission.business.port.in.UserCreateUseCase;
import com.hmk.system.permission.business.port.in.UserGetAllPermissionsUseCase;
import com.hmk.system.permission.business.port.in.UserGetAllRolesUseCase;
import com.hmk.system.permission.business.port.in.UserGetByFilterPagedUseCase;
import com.hmk.system.permission.business.port.in.UserGetByIdUseCase;
import com.hmk.system.permission.business.port.in.UserRemoveRoleUseCase;
import com.hmk.system.permission.business.port.in.UserUpdateUseCase;
import com.hmk.system.permission.web.request.UserRequest;
import com.hmk.system.permission.web.request.UserRoleRequest;
import com.hmk.system.permission.web.response.PermissionResponse;
import com.hmk.system.permission.web.response.RoleResponse;
import com.hmk.system.permission.web.response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserCreateUseCase userCreateUseCase;

    private final UserGetByFilterPagedUseCase userGetByFilterPagedUseCase;

    private final UserGetByIdUseCase userGetByIdUseCase;

    private final UserUpdateUseCase userUpdateUseCase;

    private final UserAddRoleUseCase userAddRoleUseCase;

    private final UserGetAllRolesUseCase userGetAllRolesUseCase;

    private final UserRemoveRoleUseCase userRemoveRoleUseCase;

    private final UserGetAllPermissionsUseCase userGetAllPermissionsUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@RequestBody @Valid UserRequest roleRequest) {
        var user = roleRequest.to();
        return UserResponse.from(userCreateUseCase.execute(user));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PaginationView<UserResponse> getAll(@RequestParam(name = "name", required = false, defaultValue = "") String name,
                                               @RequestParam(name = "email", required = false, defaultValue = "") String email,
                                               @RequestParam(name = "status", required = false) String status,
                                               @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                               @RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        var filter = new UserFilter(name, email, Objects.nonNull(status) ? StatusEnum.valueOf(status) : null);
        var view = userGetByFilterPagedUseCase.execute(filter, page, size);
        return PaginationView.<UserResponse>builder()
                .currentPage(page)
                .totalPages(view.getTotalPages())
                .totalItems(view.getTotalItems())
                .content(view.getContent()
                        .stream()
                        .map(UserResponse::from)
                        .collect(Collectors.toList())
                )
                .build();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getById(@PathVariable("id") Long userId) {
        return UserResponse.from(userGetByIdUseCase.execute(userId));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse update(@PathVariable("id") Long userId, @RequestBody @Valid UserRequest roleRequest) {
        var user = roleRequest.to();
        return UserResponse.from(userUpdateUseCase.execute(userId, user));
    }

    @PostMapping("/{userId}/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRole(@PathVariable("userId") Long userId, @RequestBody @Valid UserRoleRequest userRoleRequest) {
        userAddRoleUseCase.execute(userId, userRoleRequest.getRoleId());
    }

    @GetMapping("/{userId}/roles")
    @ResponseStatus(HttpStatus.OK)
    public List<RoleResponse> getAllRoles(@PathVariable("userId") Long userId) {
        var roles = userGetAllRolesUseCase.execute(userId);

        return roles.stream()
                .map(RoleResponse::from)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{userId}/roles/{roleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeRole(@PathVariable("userId") Long userId, @PathVariable("roleId") Long roleId) {
        userRemoveRoleUseCase.execute(userId, roleId);
    }

    @GetMapping("/{userId}/permissions")
    @ResponseStatus(HttpStatus.OK)
    public List<PermissionResponse> getAllPermissions(@PathVariable("userId") Long userId) {
        var permissions = userGetAllPermissionsUseCase.execute(userId);
        return permissions.stream()
                .map(PermissionResponse::from)
                .collect(Collectors.toList());
    }
}
