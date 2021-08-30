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
      this.favoriteBeerService.save(this.beerReview).subscribe(result => this.goToBeersList());
  }

}
