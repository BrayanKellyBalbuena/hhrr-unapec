import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { CandidateCommandService } from '../shared/candidate-command.service';
import { NzMessageService } from 'ng-zorro-antd';
import { Message } from '../../../core/enums/message.enum';
import { HttpStatusCode } from '../../../core/enums/http-status-code.enum';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-candidate-create',
  templateUrl: './candidate-create.component.html',

  styleUrls: ['./candidate-create.component.css']
})
export class CandidateCreateComponent implements OnInit {
  validateForm: FormGroup;
  isLoading = false;

  constructor(private fb: FormBuilder, private candidateCommnadService: CandidateCommandService,
              private messageService: NzMessageService) {}

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      firstName: [null, Validators.required],
      lastName: [null, Validators.required],
      identityCard: [null, Validators.required],
      age: [null, Validators.required],
      email: [null, [Validators.email, Validators.required]],
      userName: [null, Validators.required],
      password: [null, [Validators.required]],
      checkPassword: [null, [Validators.required, this.confirmationValidator]],
    });
  }

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }

    if (this.validateForm.valid === true) {
      this.toggleLoading()

      const candidate = this.validateForm.value;

      delete candidate['checkPassword'];

      this.candidateCommnadService.create(candidate)
      .subscribe(data => {
        this.messageService.success(Message.CREATE_SUCCES);
        this.toggleLoading();
        this.validateForm.reset();
        },
         (err: HttpErrorResponse) => {
           this.messageService.error(err.error['message']);
           this.toggleLoading();
          });
    }
  }

  updateConfirmValidator(): void {
    /** wait for refresh value */
    Promise.resolve().then(() => this.validateForm.controls.checkPassword.updateValueAndValidity());
  }

  confirmationValidator = (control: FormControl): { [s: string]: boolean } => {
    if (!control.value) {
      return { required: true };
    } else if (control.value !== this.validateForm.controls.password.value) {
      return { confirm: true, error: true };
    }
    return {};
  };

  toggleLoading() {
    this.isLoading = !this.isLoading;
  }
}
