import { Component, OnInit, Output, ViewChild, EventEmitter } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { MessageTitle } from '../../../core/enums/message-title.enum';
import { NgForm } from '@angular/forms';
import { PageRequest } from '../../../core/models/page-request';
import { CatalogWithIdAndNameQuery } from '../../../core/models/CatalogWithIdAndNameQuery';
import { AlertComponent } from '../../../../shared/alert/alert.component';
import { LanguageCreateCommand } from '../../laguanges/shared/language-create-command';
import { LanguageCommandService } from '../../laguanges/shared/language-command.service';
import { LanguageQueryService } from '../../laguanges/shared/language-query.service';

@Component({
  selector: 'app-candidate-add-language',
  templateUrl: './candidate-add-language.component.html',
  styleUrls: ['./candidate-add-language.component.css']
})
export class CandidateAddLanguageComponent implements OnInit {
  isVisible = false;
  isOkLoading = false;
  modalTitle = 'Add new Language';
  tempLanguage: LanguageCreateCommand = {name: '', description: ''};
  @Output() OnCreated = new EventEmitter<boolean>();
  @ViewChild(AlertComponent, {static: false}) alert: AlertComponent;
  @Output() createCompleted = new EventEmitter<boolean>();
  showAlert = false;
  listOfOption: CatalogWithIdAndNameQuery[];
  listOfSelectedValue: CatalogWithIdAndNameQuery[];

  constructor(private serviceCommand: LanguageCommandService, private queryService: LanguageQueryService) { }

  ngOnInit() {
    this.loadLanguages();
  }

   showModal(): void {
    this.isVisible = true;
  }

  loadLanguages() {
    this.queryService.getAllCandidateNoAssingLanguage(PageRequest.init( 50, 1))
    .subscribe(data => { this.listOfOption = data.content; console.log(data)},
      err => console.log(err));
  }

  handleOk(form: NgForm ) {
    if (!form.invalid) {
      this.toggleIsOkLoading();
      this.serviceCommand.candidateAddLanguages(this.listOfSelectedValue)
      .subscribe(() => {
        this.showAlert = true;
        this.alert.success(MessageTitle.SUCCESS);
        this.resetTempLanguage();
        form.reset();
        this.toggleIsOkLoading();
        this.createCompleted.emit(true);
      },
        (errResponse: HttpErrorResponse) => {
          this.showAlert = true;

          this.alert.error(errResponse.error['error'], errResponse.error['message']);
          this.toggleIsOkLoading();
        });
    }
  }

  toggleIsOkLoading() {
    this.isOkLoading = !this.isOkLoading;
  }

  resetTempLanguage() {
    this.tempLanguage = {name: null, description: null};
  }

  handleCancel(): void {
    this.isVisible = false;
  }

}
