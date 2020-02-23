package edu.unapec.hhrr.utils;

import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public final class Converter {
    public static Pageable PageRequestDtoToPageable(PageRequestDto pageRequestDto) {
        return PageRequest.of(pageRequestDto.getPageNumber() - 1, pageRequestDto.getPageSize(),
                Sort.by(pageRequestDto.getSortDirection(),  pageRequestDto.getSortField()));
    }
}
