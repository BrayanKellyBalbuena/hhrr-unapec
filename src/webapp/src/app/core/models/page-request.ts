export class PageRequest {
  pageNumber = 1;
  pageSize = 10;
  sortDirection = SortDirection.ASC;
  sortField = 'id';

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
