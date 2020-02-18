export class PageRequest {
  pageNumber = 1;
  pageSize = 10;
  sortDirection = SortDirection.ASC;
  sortField = 'id';

 static init(pageSize = 10, pageNumber = 1, sortDirection = SortDirection.ASC, sortField = 'id'): PageRequest {
    let pageRequest = new PageRequest();
    pageRequest.pageNumber = pageNumber;
    pageRequest.pageSize = pageSize;
    pageRequest.sortDirection = sortDirection;
    pageRequest.sortField = sortField;

    return pageRequest;
  }

  sortDirectionToggle() {
    if (this.sortDirection === SortDirection.DESC) {
      this.sortDirection = SortDirection.ASC;
    } else {
      this.sortDirection = SortDirection.DESC;
    }
  }
}

export enum SortDirection {
  ASC = 'ASC',
  DESC = 'DESC'
}
