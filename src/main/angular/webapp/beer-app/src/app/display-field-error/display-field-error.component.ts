import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'app-display-field-error',
  templateUrl: './display-field-error.component.html',
  styleUrls: ['./display-field-error.component.css']
})
export class DisplayFieldErrorComponent {

  @Input() errorMsg: string;
  @Input() displayError: boolean;

}
