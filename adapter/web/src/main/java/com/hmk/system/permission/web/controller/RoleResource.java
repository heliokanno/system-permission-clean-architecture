package com.hmk.system.permission.web.controller;

import com.hmk.system.permission.business.domain.filter.RoleFilter;
import com.hmk.system.permission.business.domain.view.PaginationView;
import com.hmk.system.permission.business.port.in.RoleAddPermissionUseCase;
import com.hmk.system.permission.business.port.in.RoleCreateUseCase;
import com.hmk.system.permission.business.port.in.RoleGetAllPermissionsUseCase;
import com.hmk.system.permission.business.port.in.RoleGetByFilterPagedUseCase;
import com.hmk.system.permission.business.port.in.RoleGetByIdUseCase;
import com.hmk.system.permission.business.port.in.RoleRemovePermissionUseCase;
import com.hmk.system.permission.business.port.in.RoleUpdateUseCase;
import com.hmk.system.permission.web.request.RolePermissionRequest;
import com.hmk.system.permission.web.request.RoleRequest;
import com.hmk.system.permission.web.response.PermissionResponse;
import com.hmk.system.permission.web.response.RoleResponse;
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
import java.util.stream.Collectors;


@RestController
@RequestMapping("/v1/roles")
@RequiredArgsConstructor
public class RoleResource {

    private final RoleCreateUseCase roleCreateUseCase;

    private final RoleGetByFilterPagedUseCase roleGetByFilterPagedUseCase;

    private final RoleGetByIdUseCase roleGetByIdUseCase;

    private final RoleUpdateUseCase roleUpdateUseCase;

    private final RoleAddPermissionUseCase roleAddPermissionUseCase;

    private final RoleGetAllPermissionsUseCase roleGetAllPermissionsUseCase;

    private final RoleRemovePermissionUseCase roleRemovePermissionUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoleResponse create(@RequestBody @Valid RoleRequest roleRequest) {
        var role = roleRequest.to();
        return RoleResponse.from(roleCreateUseCase.execute(role));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PaginationView<RoleResponse> getAll(@RequestParam(name = "name", required = false, defaultValue = "") String name,
                                               @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                               @RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        var filter = new RoleFilter(name);
        var view = roleGetByFilterPagedUseCase.execute(filter, page, size);
        return PaginationView.<RoleResponse>builder()
                .currentPage(page)
                .totalPages(view.getTotalPages())
                .totalItems(view.getTotalItems())
                .content(view.getContent()
                        .stream()
                        .map(RoleResponse::from)
                        .collect(Collectors.toList())
                )
                .build();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoleResponse getById(@PathVariable("id") Long roleId) {
        return RoleResponse.from(roleGetByIdUseCase.execute(roleId));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoleResponse update(@PathVariable("id") Long roleId, @RequestBody @Valid RoleRequest roleRequest) {
        var role = roleRequest.to();
        return RoleResponse.from(roleUpdateUseCase.execute(roleId, role));
    }

    @PostMapping("/{roleId}/permissions")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRole(@PathVariable("roleId") Long roleId, @RequestBody @Valid RolePermissionRequest request) {
        roleAddPermissionUseCase.execute(roleId, request.getPermissionId());
    }

    @GetMapping("/{roleId}/permissions")
    @ResponseStatus(HttpStatus.OK)
    public List<PermissionResponse> getAllPermissions(@PathVariable("roleId") Long roleId) {
        var permissions = roleGetAllPermissionsUseCase.execute(roleId);

        return permissions.stream()
                .map(PermissionResponse::from)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{roleId}/permissions/{permissionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeRole(@PathVariable("roleId") Long roleId, @PathVariable("permissionId") Long permissionId) {
        roleRemovePermissionUseCase.execute(roleId, permissionId);
    }
}
