import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FavoriteBeerService} from "../service/favorite-beer.service";
import {BeerReview} from "../model/beer-review";
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {HttpErrorResponse} from "@angular/common/http";
import {DisplayFieldErrorComponent} from "../display-field-error/display-field-error.component";

@Component({
  selector: 'app-favorite-beer-form',
  templateUrl: './favorite-beer-form.component.html',
  styleUrls: ['./favorite-beer-form.component.css']
})
export class FavoriteBeerFormComponent implements OnInit {

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
    this.route.paramMap.subscribe(params => {
      console.log(params);
      var beerId: number = +params.get('beerId')!;
      this.beerReview.beerId = beerId;
    })
  }

  onSubmit() {
    this.favoriteBeerService.save(this.beerReview).subscribe(
      (result) => { //Next callback
        alert('beer ' + this.beerReview.beerId + ' was saved as favorite ');
        this.goToBeersList();
      },
      (error: HttpErrorResponse) => { //Error callback
        if (error.status === 409) {
          alert('Beer ' + this.beerReview.beerId + " was already saved as a favorite");
        } else if (error.status === 400) {
          alert('Invalid data, please check the fields again');
        } else {
          alert('Bad response from server');
        }
      }
    );
  }

}
