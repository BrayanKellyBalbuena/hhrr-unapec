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
import { CandidateCommandService } from '../shared/candidate-command.service';
import { JobDetailsComponent } from '../../../../shared/components/job-details/job-details.component';
import { Message } from '../../../core/enums/message.enum';


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
    { value: 'name', displayName: 'Name' },
    { value: 'riskLevel', displayName: 'Risk level'},
    { value: 'mininumSalary', displayName: 'Mininum Salary' },
    { value: 'maximunSalary', displayName: 'Maximun Salary' },
    { value: 'createdDate', displayName: 'Date Publish'}
  ];

  filtersProperties = [
    { value: 'id', displayName: 'Number' },
    { value: CatalogSeachField.NAME, displayName: 'Name' },
    { value: 'riskLevel', displayName: 'Risk level'},
    { value: 'mininumSalary', displayName: 'Mininum Salary' },
    { value: 'maximunSalary', displayName: 'Maximun Salary' },
    { value: 'createdDate', displayName: 'Date Publish'}
  ];
  searchGenderList: string[] = [];
  selectedFilter: string | null;
  inputSearch: string | null;
  @ViewChild(AlertComponent, {static: false}) alert: AlertComponent;
  @ViewChild(JobDetailsComponent, {static: false}) jobDetailsComponent: JobDetailsComponent;

  constructor(private jobQueryService: JobQueryService,
              private commandService: CandidateCommandService ) {
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
    this.jobQueryService.getCandidateNoApplyJobs(this.pageRequest).subscribe(data => {
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
      this.jobQueryService
        .getById(+searchText)
        .subscribe(data => this.listOfData.push(data));
    } else if (this.selectedFilter === CatalogSeachField.NAME) {
      this.jobQueryService
        .getByName(searchText, this.pageRequest)
        .subscribe(data => (this.listOfData = data.content));
    } else if (this.selectedFilter === CatalogSeachField.DESCRIPTION) {
      this.jobQueryService
        .getByDescription(searchText, this.pageRequest)
        .subscribe(data => (this.listOfData = data.content));
    }
  }


  viewDetails(job: JobQuery) {
    this.jobDetailsComponent.showModal(Object.assign({}, job) );
  }

  onUpdateComplete($event: true) {
    this.searchData();
    this.alert.success(Message.UPDATE_SUCCESS);
  }

  onCreateCompleted($event) {
    this.searchData();
  }
}
