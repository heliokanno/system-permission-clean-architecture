package com.hmk.system.permission.web.controller;

import com.hmk.system.permission.business.domain.filter.PermissionFilter;
import com.hmk.system.permission.business.domain.view.PaginationView;
import com.hmk.system.permission.business.port.in.PermissionCreateUseCase;
import com.hmk.system.permission.business.port.in.PermissionGetByFilterPagedUseCase;
import com.hmk.system.permission.business.port.in.PermissionGetByIdUseCase;
import com.hmk.system.permission.business.port.in.PermissionUpdateUseCase;
import com.hmk.system.permission.web.request.PermissionRequest;
import com.hmk.system.permission.web.response.PermissionResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;


@RestController
@RequestMapping("/v1/permissions")
@RequiredArgsConstructor
public class PermissionResource {

    private final PermissionCreateUseCase permissionCreateUseCase;

    private final PermissionGetByFilterPagedUseCase permissionGetByFilterPagedUseCase;

    private final PermissionGetByIdUseCase permissionGetByIdUseCase;

    private final PermissionUpdateUseCase permissionUpdateUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PermissionResponse create(@RequestBody @Valid PermissionRequest permissionRequest) {
        var permission = permissionRequest.to();
        return PermissionResponse.from(permissionCreateUseCase.execute(permission));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PaginationView<PermissionResponse> getAll(@RequestParam(name = "name", required = false, defaultValue = "") String name,
                                                     @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                                     @RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        var filter = new PermissionFilter(name);
        var view = permissionGetByFilterPagedUseCase.execute(filter, page, size);
        return PaginationView.<PermissionResponse>builder()
                .currentPage(page)
                .totalPages(view.getTotalPages())
                .totalItems(view.getTotalItems())
                .content(view.getContent()
                        .stream()
                        .map(PermissionResponse::from)
                        .collect(Collectors.toList())
                )
                .build();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PermissionResponse getById(@PathVariable("id") Long permissionId) {
        return PermissionResponse.from(permissionGetByIdUseCase.execute(permissionId));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PermissionResponse update(@PathVariable("id") Long permissionId, @RequestBody @Valid PermissionRequest permissionRequest) {
        var role = permissionRequest.to();
        return PermissionResponse.from(permissionUpdateUseCase.execute(permissionId, role));
    }
}
