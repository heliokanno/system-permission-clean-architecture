package com.hmk.system.permission.business.domain.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PaginationView<T> {
    private Long totalItems;
    private Integer totalPages;
    private Integer currentPage;
    private List<T> content;
}
