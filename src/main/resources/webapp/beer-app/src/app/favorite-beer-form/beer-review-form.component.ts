import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FavoriteBeerService} from "../service/favorite-beer.service";
import {BeerReview} from "../model/beer-review";
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-favorite-beer-form',
  templateUrl: './beer-review-form.component.html',
  styleUrls: ['./beer-review-form.component.css']
})
export class BeerReviewFormComponent implements OnInit {

  form: FormGroup;

  beerReview: BeerReview;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private formBuilder: FormBuilder,
              private favoriteBeerService: FavoriteBeerService) {
    this.beerReview = new BeerReview();
  }

  goToBeersList() {
    this.router.navigate(['/beers']);
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      userEmail: [null, [Validators.required, Validators.email]],
      beerId: [null, Validators.required],
      drunkBefore: [null],
      whereTasted: [null],
      whenTasted: [null],
      tasteNote: [null],
      comments: [null,]
    });
  }

  onSubmit() {
      this.favoriteBeerService.save(this.beerReview).subscribe(result => this.goToBeersList());
  }

  // onSubmit() {
  //   console.log(this.form);
  //   if (this.form.valid) {
  //     console.log('form submitted');
  //     this.favoriteBeerService.save(this.beerReview).subscribe(result => this.goToBeersList());
  //   } else {
  //     this.validateAllFormFields(this.form);
  //   }
  // }

  isFieldValid(field: string) {
    // @ts-ignore
    return !this.form.get(field).valid && this.form.get(field).touched;
  }

  displayFieldCss(field: string) {
    return {
      'has-error': this.isFieldValid(field),
      'has-feedback': this.isFieldValid(field)
    };
  }

  validateAllFormFields(formGroup: FormGroup) {
    Object.keys(formGroup.controls).forEach(field => {
      console.log(field);
      const control = formGroup.get(field);
      if (control instanceof FormControl) {
        control.markAsTouched({onlySelf: true});
      } else if (control instanceof FormGroup) {
        this.validateAllFormFields(control);
      }
    });
  }

  reset() {
    this.form.reset();
  }

}
