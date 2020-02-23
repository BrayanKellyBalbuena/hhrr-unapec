package edu.unapec.hhrr.infrastructure.dtos.queries;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class PageRequestDto {
   int pageNumber = 1;
   int pageSize = 10;
   String sortField = "id";
   Sort.Direction sortDirection = Sort.Direction.ASC;
}
