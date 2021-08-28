import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {FavoriteBeerService} from "../service/favorite-beer.service";
import {FavoriteBeer} from "../model/favorite-beer";
import {BeerReview} from "../model/beer-review";

@Component({
  selector: 'app-favorite-beer-form',
  templateUrl: './favorite-beer-form.component.html',
  styleUrls: ['./favorite-beer-form.component.css']
})
export class FavoriteBeerFormComponent implements OnInit {

  // favoriteBeer: FavoriteBeer;
  //
  // constructor(  private route: ActivatedRoute,
  //               private router: Router,
  //               private favoriteBeerService: FavoriteBeerService) {
  //   this.favoriteBeer = new FavoriteBeer();
  // }

  beerReview: BeerReview;

  constructor(  private route: ActivatedRoute,
                private router: Router,
                private favoriteBeerService: FavoriteBeerService) {
    this.beerReview = new BeerReview();
  }

  onSubmit() {
    this.favoriteBeerService.save(this.beerReview).subscribe(result => this.goToBeersList());
  }

  goToBeersList() {
    this.router.navigate(['/beers']);
  }

  ngOnInit(): void {
  }

}
