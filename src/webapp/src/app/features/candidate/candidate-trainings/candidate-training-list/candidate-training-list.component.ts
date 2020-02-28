import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';

import { debounceTime, distinctUntilChanged, tap, map } from 'rxjs/operators';
import { FormControl } from '@angular/forms';
import { TrainingQuery } from '../../../training/shared/training-query';
import { PageRequest } from '../../../../core/models/page-request';
import { CatalogSeachField } from '../../../../core/enums/catalog-seach-field.enum';
import { AlertComponent } from '../../../../../shared/alert/alert.component';
import { TrainingUpdateComponent } from '../../../training/training-update/training-update.component';
import { TrainingQueryService } from '../../../training/shared/training-query.service';
import { TrainingCommandService } from '../../../training/shared/training-command.service';
import { HttpErrorResponse } from '@angular/common/http';
import { TrainingUpdateCommand } from '../../../training/shared/training-update-command';
import { CandidateTrainingUpdateComponent } from '../candidate-training-update/candidate-training-update.component';




@Component({
  selector: 'app-training-list',
  templateUrl: './candidate-training-list.component.html',
  styleUrls: ['./candidate-training-list.component.css']
})
export class CandidateTrainingListComponent implements OnInit, AfterViewInit {
  searchField: FormControl = new FormControl();
  pageRequest: PageRequest;
  totalPage: number;
  listOfData: TrainingQuery[] = [];
  loading = true;
  sortValue: string | null = null;
  sortKey: string | null = null;
  showAlert = false;

  sortProperties = [
    { value: 'id', displayName: 'Number' },
    { value: 'institution', displayName: 'Institution'},
    { value: 'name', displayName: 'Name' },
    { value: 'dateTo', displayName: 'Date to' },
    { value: 'dateFrom', displayName: 'Date from'},
    { value: 'description', displayName: 'Description'}
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
  @ViewChild(CandidateTrainingUpdateComponent, {static: false}) updateComponent: CandidateTrainingUpdateComponent;

  constructor(private queryService: TrainingQueryService,
              private commandService: TrainingCommandService ) {
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
    this.queryService.getByCandidateId(this.pageRequest).subscribe(data => {
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
    // if (this.selectedFilter === 'id') {
    //   this.queryService
    //     .getById(+searchText)
    //     .subscribe(data => this.listOfData.push(data));
    // } else if (this.selectedFilter === CatalogSeachField.NAME) {
    //   this.queryService
    //     .getByName(searchText, this.pageRequest)
    //     .subscribe(data => (this.listOfData = data.content));
    // } else if (this.selectedFilter === CatalogSeachField.DESCRIPTION) {
    //   this.queryService
    //     .getByDescription(searchText, this.pageRequest)
    //     .subscribe(data => (this.listOfData = data.content));
    // }
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

  update(updateCommnad: TrainingUpdateCommand) {
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
