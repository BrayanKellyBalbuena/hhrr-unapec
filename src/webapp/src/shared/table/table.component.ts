// import { Component, OnInit, Input } from '@angular/core';
// import { PageRequest } from '../../app/core/models/page-request';

// @Component({
//   selector: 'app-table',
//   templateUrl: './table.component.html',
//   styleUrls: ['./table.component.css']
// })
// export class TableComponent implements OnInit {
//   @Input() pageRequest: PageRequest;
//   totalPage: number;
//   @Input() listOfData: LanguageQuery[] = [];
//   loading = true;
//   sortValue: string | null = null;
//   sortKey: string | null = null;
//   filterGender = [{ text: 'male', value: 'male' }, { text: 'female', value: 'female' }];
//   sortProperties = [{value: 'id', displayName: 'Number'}, {value: 'name', displayName: 'Name'},
//   {value: 'description', displayName: 'Description'}];

//   filtersProperties = [{value: 'id', displayName: 'Number'}, {value: 'name', displayName: 'Name'},
//   {value: 'description', displayName: 'Description'}];
//   searchGenderList: string[] = [];
//   selectedFilter: string | null;
//   inputSearch: string | null;

//   constructor(protected service: LanguageQueryService) {
//     this.pageRequest = new PageRequest();
//   }
//   ngOnInit(): void {
//     this.searchData();
//   }

//   sort(sort: { key: string; value: string }): void {
//     this.sortKey = sort.key;
//     this.sortValue = sort.value;
//     console.log({sortkey: this.sortKey, sortValue: this.sortValue});
//     this.pageRequest.sortField = this.sortKey;

//     this.searchData();
//     this.pageRequest.sortDirectionToggle();
//   }

//   searchData(reset: boolean = false): void {
//     if (reset) {
//       this.pageRequest.pageNumber = 1;
//     }
//     this.loading = true;
//     this.service.getAll(this.pageRequest)
//       .subscribe(data => {
//         this.loading = false;
//         this.totalPage = data.totalElements;
//         this.listOfData = data.content;
//       });
//   }

//   updateFilter(value: string[]): void {
//     this.searchGenderList = value;
//     this.searchData(true);
//   }

//   onInputSearch(value: any) {}

// }
