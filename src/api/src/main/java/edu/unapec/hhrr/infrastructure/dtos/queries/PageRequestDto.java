package edu.unapec.hhrr.infrastructure.dtos.queries;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class PageRequestDto {
   int pageNumber = 1;
   int pageSize = 20;
   String sortField = "id";
   Sort.Direction sortDirection = Sort.Direction.ASC;
}
