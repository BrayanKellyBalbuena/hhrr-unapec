import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { PageRequest } from '../../../core/models/page-request';
import { CatalogSeachField } from '../../../core/enums/catalog-seach-field.enum';

import { debounceTime, distinctUntilChanged, tap, map } from 'rxjs/operators';
import { FormControl } from '@angular/forms';
import { AlertComponent } from '../../../../shared/alert/alert.component';
import { HttpErrorResponse } from '@angular/common/http';
import { JobQuery } from '../../jobs/shared/job-query';
import { JobUpdateComponent } from '../../jobs/job-update/job-update.component';
import { JobQueryService } from '../../jobs/shared/job-query.service';
import { JobCommandService } from '../../jobs/shared/job-command.service';
import { JobUpdateCommand } from '../../jobs/shared/job-update-command';


@Component({
  selector: 'app-candidate-search-jobs',
  templateUrl: './candidate-search-jobs.component.html',
  styleUrls: ['./candidate-search-jobs.component.css']
})
export class CandidateJobSeachListComponent implements OnInit, AfterViewInit {
  searchField: FormControl = new FormControl();
  pageRequest: PageRequest;
  totalPage: number;
  listOfData: JobQuery[] = [];
  loading = true;
  sortValue: string | null = null;
  sortKey: string | null = null;
  showAlert = false;

  sortProperties = [
    { value: 'id', displayName: 'Number' },
    { value: 'riskLevel', displayName: 'Risk level'},
    { value: 'name', displayName: 'Name' },
    { value: 'mininumSalary', displayName: 'Mininum Salary' },
    { value: 'maximunSalary', displayName: 'Maximun Salary' },
    // { value: 'description', displayName: 'Description' }
  ];

  filtersProperties = [
    { value: 'id', displayName: 'Number' },
    { value: CatalogSeachField.NAME, displayName: 'Name' },
    { value: CatalogSeachField.DESCRIPTION, displayName: 'Description' }
  ];
  searchGenderList: string[] = [];
  selectedFilter: string | null;
  inputSearch: string | null;
  @ViewChild(AlertComponent, {static: false}) alert: AlertComponent;
  @ViewChild(JobUpdateComponent, {static: false}) updateComponent: JobUpdateComponent;

  constructor(private queryService: JobQueryService,
              private commandService: JobCommandService ) {
    this.pageRequest = new PageRequest();
  }
  ngOnInit(): void {
    this.searchData();
  }

  ngAfterViewInit(): void {
    this.searchField.valueChanges
      .pipe(debounceTime(200), distinctUntilChanged())
      .subscribe(term => {
        this.onInputSearch(term);
      });
  }

  sort(sort: { key: string; value: string }): void {
    this.sortKey = sort.key;
    this.sortValue = sort.value;
    this.pageRequest.sortField = this.sortKey;

    this.searchData();
    this.pageRequest.sortDirectionToggle();
  }

  searchData(reset: boolean = false): void {
    if (reset) {
      this.pageRequest.pageNumber = 1;
    }
    this.loading = true;
    this.queryService.getAll(this.pageRequest).subscribe(data => {
      this.loading = false;
      this.totalPage = data.totalElements;
      this.listOfData = data.content;
    });
  }

  updateFilter(value: string[]): void {
    this.searchGenderList = value;
    this.searchData(true);
  }

  onInputSearch(searchText: string) {
    console.log(searchText);

    this.listOfData = [];

    if (searchText === '') {
      this.searchData();
      return ;
    }
    if (this.selectedFilter === 'id') {
      this.queryService
        .getById(+searchText)
        .subscribe(data => this.listOfData.push(data));
    } else if (this.selectedFilter === CatalogSeachField.NAME) {
      this.queryService
        .getByName(searchText, this.pageRequest)
        .subscribe(data => (this.listOfData = data.content));
    } else if (this.selectedFilter === CatalogSeachField.DESCRIPTION) {
      this.queryService
        .getByDescription(searchText, this.pageRequest)
        .subscribe(data => (this.listOfData = data.content));
    }
  }

  delete(id: number) {
    this.commandService.delete(id).subscribe(result => {
      this.showAlert = true;
      this.alert.success('Delete Sucessfully');
      this.searchData();
    },
      (errResponse: HttpErrorResponse) => {
        console.log(errResponse);
        this.showAlert = true;
        this.alert.error(errResponse.error['error'], errResponse.error['message']);
      });
  }

  apply(updateCommnad: JobUpdateCommand) {
    this.updateComponent.showModal( Object.assign({}, updateCommnad) );
  }

  onUpdateComplete($event: true) {
    this.searchData();
    this.alert.success('Update Successfully');
  }

  onCreateCompleted($event) {
    this.searchData();
  }
}
