import { Component, OnInit, Input } from '@angular/core';
import { AlertType } from '../../app/core/enums/alert-type';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.css']
})
export class AlertComponent {
  type: string;
  message = '';
  description = '';
  showIcon = true;
  @Input() showAlert = false;

  success(message: string, description = '') {
    this.type = AlertType.SUCCESS;
    this.message = message;
    this.description = description;
    this.showAlert = true;
  }

  info(message: string, description = '') {
    this.type = AlertType.INFO;
    this.message = message;
    this.description = description;
    this.showAlert = true;
  }

  warn(message: string, description = '') {
    this.type = AlertType.WARNING;
    this.message = message;
    this.description = description;
    this.showAlert = true;
  }

  error(message: string, description = '') {
    this.type = AlertType.ERROR;
    this.message = message;
    this.description = description;
    this.showAlert = true;
  }

  afterClose() {
    this.showAlert = false;
    return;
  }
}

